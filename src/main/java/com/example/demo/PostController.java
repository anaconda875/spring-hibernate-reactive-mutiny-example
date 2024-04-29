package com.example.demo;

import static org.springframework.http.ResponseEntity.*;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
class PostController {

  private final PostRepository repository;

  @GetMapping
  public Flux<Post> findAllByContent(String content, Pageable pageable) {
    return repository.findByContent(content, pageable);
  }

  @GetMapping("/all")
  public Flux<Post> findAllPageable(Pageable pageable) {
    return repository.findAll(pageable);
  }

  /*private final PostRepository1 posts;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> all() {
      return ok().body(this.posts.findAll());
  }

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Uni<ResponseEntity<?>> create(@RequestBody CreatePostCommand data) {
      return this.posts.save(
              Post.builder()
                  .title(data.getTitle())
                  .content(data.getContent())
                  .build()
          )
          .map(p -> created(URI.create("/posts/" + p.getId())).build());
  }

  @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Uni<ResponseEntity<Post>> get(@PathVariable UUID id) {
      return this.posts.findById(id)
          .map(post -> ok().body(post));
  }

  @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Uni<ResponseEntity<?>> update(@PathVariable UUID id, @RequestBody UpdatePostCommand data) {

      return Uni.combine().all()
          .unis(
              this.posts.findById(id),
              Uni.createFrom().item(data)
          )
          .combinedWith((p, d) -> {
              p.setTitle(d.getTitle());
              p.setContent(d.getContent());
              return p;
          })
          .flatMap(this.posts::save)
          .map(post -> noContent().build());
  }

  @DeleteMapping("{id}")
  public Uni<ResponseEntity<?>> delete(@PathVariable UUID id) {
      return this.posts.deleteById(id).map(d -> noContent().build());
  }*/
}
