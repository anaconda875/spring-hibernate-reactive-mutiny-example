package com.example.demo;

import com.htech.data.jpa.reactive.repository.ReactiveJpaRepository;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostRepository extends ReactiveJpaRepository<Post, UUID> {

  Flux<Post> findByContentOrderByCreatedAt(String content);

  Flux<Post> findByContent(String content, Pageable pageable);

  @Query("SELECT p FROM Post p WHERE p.title = ?1")
  Flux<Post> custom(String title);

  @Query("SELECT p FROM Post p WHERE p.title = :title")
  Flux<Post> custom1(@Param("title") String title);

  @Query("SELECT p FROM Post p WHERE p.content = :content ORDER BY p.id")
  Mono<Post> custom2(@Param("content") String content);

  @Query("SELECT p FROM Post p WHERE p.content = :content ORDER BY p.id")
  Mono<Post> custom3(@Param("content") String content);

  @Query(
      nativeQuery = true,
      value = "SELECT id, title, content, created_at FROM posts WHERE id = ?1")
  Mono<Post> nativeQ(UUID id);

  @Query(
      nativeQuery = true,
      value = "SELECT id, title, content, created_at FROM posts WHERE content = :content")
  Flux<Post> nativeQ2(@Param("content") String content);

  //  Mono<Boolean> existsById(UUID id);

  Mono<Long> countByTitleOrContent(String title, String content);

  @Modifying
  @Query("UPDATE Post p SET p.content = ?2 WHERE p.id = ?1")
  @Transactional
  Mono<Integer> update(UUID id, String content);

  @Modifying
  @Query(nativeQuery = true, value = "UPDATE posts SET content = ?2 WHERE id = ?1")
  @Transactional
  Mono<Integer> updateNative(UUID id, String content);

  Mono<?> deleteByTitle(String title);

  @Modifying
  @Query(nativeQuery = true, value = "DELETE from posts WHERE content = ?1")
  @Transactional
  Mono<?> deleteNative(String content);

  @Modifying
  @Query(nativeQuery = true, value = "DELETE from posts WHERE content = :content")
  @Transactional
  Mono<?> deleteNative2(@Param("content") String content);

  @Modifying
  @Query("DELETE FROM Post p WHERE p.title = :title")
  Mono<?> deleteCustom(@Param("title") String title);
}
