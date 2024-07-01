package com.example.demo;

import com.htech.data.jpa.reactive.repository.ReactiveJpaRepository;
import jakarta.persistence.LockModeType;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostRepository extends ReactiveJpaRepository<Post, UUID> {

  @Override
  @Lock(LockModeType.OPTIMISTIC)
  @EntityGraph(attributePaths = {"content"})
  <S extends Post> Flux<S> findAll();

  @Lock(LockModeType.PESSIMISTIC_READ)
  @EntityGraph(attributePaths = {"content"})
  Flux<Post> findByContentOrderByCreatedAtDesc(String content);

  //
  //  Mono<Page<Post>> findByContent(String content, Pageable pageable);

  @Query("SELECT p FROM Post p WHERE p.content = ?1")
  Mono<Page<Post>> findByContentCustomPage(String content, Pageable pageable);

  //  @Query("SELECT p FROM Post p WHERE p.title = ?1")
  //  Flux<Post> custom(String title);
  //
  //  @Query("SELECT p FROM Post p WHERE p.title = :title")
  //  Flux<Post> custom1(@Param("title") String title);
  //
  //  @Query("SELECT p FROM Post p WHERE p.content = :content ORDER BY p.id")
  //  Flux<Post> custom2(@Param("content") String content);
  //
  //  @Query("SELECT p FROM Post p WHERE p.content = :content ")
  //  Mono<Post> custom3(@Param("content") String content);
  //
  //  @Query(
  //      nativeQuery = true,
  //      value =
  //          "SELECT id, title, content, created_at, created_by, last_modified_at, last_modified_by
  // FROM posts WHERE id = ?1")
  //  Mono<Post> nativeQ(UUID id);
  //
  @Query(
      nativeQuery = true,
      value =
          "SELECT id, title, content, created_at, created_by, last_modified_at, last_modified_by "
              + "FROM posts WHERE content = :content")
  Flux<Post> nativeQ2(@Param("content") String content);

  //
  //  //  Mono<Boolean> existsById(UUID id);
  //
  //  Mono<Long> countByTitleOrContent(String title, String content);
  //
  //  @Modifying
  //  @Query("UPDATE Post p SET p.content = ?2 WHERE p.id = ?1")
  //  @Transactional
  //  Mono<Integer> update(UUID id, String content);
  //
  //  @Modifying
  //  @Query(nativeQuery = true, value = "UPDATE posts SET content = ?2 WHERE id = ?1")
  //  @Transactional
  //  Mono<Integer> updateNative(UUID id, String content);
  //
  //  Mono<?> deleteByTitle(String title);
  //
  //  @Modifying
  //  @Query(nativeQuery = true, value = "DELETE from posts WHERE content = ?1")
  //  @Transactional
  //  Mono<?> deleteNative(String content);
  //
  //  @Modifying
  //  @Query(nativeQuery = true, value = "DELETE from posts WHERE content = :content")
  //  @Transactional
  //  Mono<?> deleteNative2(@Param("content") String content);
  //
  //  @Modifying
  //  @Query("DELETE FROM Post p WHERE p.title = :title")
  //  Mono<?> deleteCustom(@Param("title") String title);
  //
  //  @Query("SELECT p from Post p WHERE p.title = ?1 AND p.createdBy = :#{authentication.name}")
  //  Flux<Post> testSpel(String title);
  //
  //  @Query(
  //      nativeQuery = true,
  //      value =
  //          "SELECT id, title, content, created_at, created_by, last_modified_at, last_modified_by
  // FROM posts WHERE created_by = :#{authentication.name} AND title = :title")
  //  Flux<Post> testSpelNative(String title);
  //
  //  @Query(
  //      nativeQuery = true,
  //      value =
  //          "SELECT id, title, content, created_at, created_by, last_modified_at, last_modified_by
  // FROM posts WHERE created_by = :#{authentication.name} AND title = :title AND last_modified_by =
  // :#{authentication.name}")
  //  Mono<Post> testSpelNative2(@Param("title") String title);

  @Query(
      "SELECT p from #{#entityName} p WHERE p.lastModifiedBy = :#{authentication.name} AND p.title = ?1 AND p.createdBy = :#{authentication.name}")
  @EntityGraph(attributePaths = {"createdBy"})
  Mono<Post> testSpel3(String title);

  @Lock(LockModeType.READ)
  @EntityGraph
  Mono<Page<Post>> testNamed(String content, Pageable pageable);
}
