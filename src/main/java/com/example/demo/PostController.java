package com.example.demo;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
class PostController {

  private final ARepo aRepo;
  private final BRepo bRepo;
  private final PostRepository repository;
  private final Sv sv;

  PostController(ARepo aRepo, BRepo bRepo, PostRepository repository, Sv sv) {
		this.aRepo = aRepo;
		this.bRepo = bRepo;
		this.repository = repository;
    this.sv = sv;
  }

  @PutMapping
  @Transactional
  Flux<B> a() {
//    A a = new A();
//    B b = new B();
//    return aRepo.save( a ).flatMap( saved -> {
//      b.setA( saved );
//      return bRepo.save( b );
//    } ).then();

    return aRepo.findAll().concatMap( l -> Flux.fromIterable( l.getBs() ) );
  }

  @PostMapping
  @Transactional
  public Flux<Post> create(String title) {
//    return repository.findByContentOrderByCreatedAtDesc( "content" );
    return Flux.concat(sv.test(title), (repository.testSpel3(title)));
    //    return repository
    //        .findById(UUID.fromString("3a892e30-0142-496e-acc4-af76599cd811"))
    //        .flatMap(repository::save);
    //        return repository.save(Post.builder().content("au1").title("au1").build());
  }

  @GetMapping
  //  @Transactional
  public Mono<Page<Post>> findAllByContent(String content, Pageable pageable) {
    return repository.findByContentCustomPage(content, pageable);
  }

  @GetMapping("/all")
  @Transactional
  public Mono<Page<Post>> findAllPageable(Pageable pageable) {
    return null;
    //    return repository.findAll(pageable);
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
