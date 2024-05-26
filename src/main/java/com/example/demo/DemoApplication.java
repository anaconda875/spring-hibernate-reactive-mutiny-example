package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoApplication {
  public static void main(String[] args) {
    System.setProperty("org.hibernate.reactive.common.InternalStateAssertions.ENFORCE", "false");
    SpringApplication.run(DemoApplication.class, args);
  }

  //    @Bean
  //    public Mutiny.SessionFactory sessionFactory() {
  //        return Persistence.createEntityManagerFactory("blogPU")
  //            .unwrap(Mutiny.SessionFactory.class);
  //    }

  //    @Bean
  //    public Mutiny.SessionFactory sessionFactory(EntityManagerFactory emf) {
  //        return emf
  //            .unwrap(Mutiny.SessionFactory.class);
  //    }

  @Bean
  CommandLineRunner testRepo(PostRepository interfaceRepo /*, PostRepository1 postRepository1*/) {
    return args -> {
      //      Uni<Integer> session =
      // Uni.createFrom().completionStage(CompletionStages.zeroFuture());
      //      Mono sessionMono = ReactiveWrapperConverters.toWrapper(session, Mono.class);
      //
      //      sessionMono.flatMap(s -> {
      //        Uni<Boolean> b = Uni.createFrom().completionStage(CompletionStages.trueFuture())
      //            .chain(() -> Uni.createFrom().completionStage(CompletionStages.falseFuture()));
      //
      //        return ReactiveWrapperConverters.toWrapper(b, Mono.class);
      //      }).doOnError(e -> System.err.println("Error 1: " + e))
      //          .flatMap(s -> Mono.error(new RuntimeException("E")))
      //          .doOnError(e -> System.err.println("Error 2: " + e))
      //          .subscribe(System.out::println);

      //      Mono.just("a")
      //          .doOnError(e -> System.err.println("Error 1: " + e))
      //          .map(String::toUpperCase)
      //          .doOnError(e -> System.err.println("Error 2: " + e))
      //          .flatMap(s -> Mono.error(new RuntimeException("e")))
      //          .doOnError(e -> System.err.println("Error 3: " + e))
      //          .subscribe();

      //                  interfaceRepo.findById(
      //                      UUID.fromString("ea7d52c9-0754-4820-856e-ef7cb8571dd8"))
      //                      .subscribe(System.out::println);
      //                  interfaceRepo.findAllById(
      //                      List.of(UUID.fromString("ea7d52c9-0754-4820-856e-ef7cb8571dd8"),
      //                              UUID.fromString("d1736c74-0b12-410f-bf5a-5ac776b56aaa"),
      //                              UUID.randomUUID(),
      //                              UUID.fromString("26c6c345-33bb-46a3-830b-f534fe8989ee")))
      //                      .subscribe(System.out::println);
      //                  interfaceRepo.count().subscribe(System.out::println);

      //      Mono<Post> save = interfaceRepo.save(Post.builder()
      //          .title("a1")
      //          .content("b2")
      //          .build());
      //
      //      save
      //                      .flatMap(i -> Mono.error(new RuntimeException(i.getTitle())))
      //                      .subscribe(System.out::println);
      //                  interfaceRepo.save(Post.builder()
      //                      .title("a1")
      //                      .content("b2")
      //                      .build()).subscribe(System.out::println, System.err::println);
      //            interfaceRepo.save(Post.builder()
      //                .title("tit")
      //                .content("content")
      //                .build()).subscribe(System.out::println, System.err::println);

      //
      //
      // interfaceRepo.findByContentOrderByCreatedAt("content1").subscribe(System.out::println);
      //                  interfaceRepo.custom("trans").subscribe(System.out::println);
      //                  interfaceRepo.custom1("trans").subscribe(System.out::println);
      //                  interfaceRepo.custom2("b2").subscribe(System.out::println);

      //                  interfaceRepo.nativeQ2("trans")
      //                      .subscribe(System.out::println);

      //      interfaceRepo.nativeQ(UUID.fromString("31dd7fa6-378a-498d-9b30-06cf14d4c94f"))
      //          .subscribe(System.out::println);

      //                  interfaceRepo.testNamedQuery("content").subscribe(System.out::println);

      //
      //       interfaceRepo.existsById(UUID.fromString("43022da0-d025-42c1-90b1-00b1d23d037b "))
      //                      .subscribe(System.out::println);
      //      interfaceRepo.existsById(UUID.fromString("3e6bd218-4bc9-49a5-862f-a8cb312b8294"))
      //          .subscribe(System.out::println);
      //
      //                  interfaceRepo.countByTitleOrContent("tit",
      // "trans").subscribe(System.out::println);

      //
      // interfaceRepo.update(UUID.fromString("31dd7fa6-378a-498d-9b30-06cf14d4c94f"),
      //       "contentttttttttttt").subscribe(System.out::println);

      //
      //       interfaceRepo.updateNative(UUID.fromString("31dd7fa6-378a-498d-9b30-06cf14d4c94f"),
      // "b2")
      //                      .subscribe(System.out::println);

      //                  interfaceRepo.deleteByTitle("a1").subscribe(System.out::println);

      //                  interfaceRepo.deleteNative("b2").subscribe(System.out::println);
      //
      //       interfaceRepo.deleteNative2("b2").subscribe(System.out::println);
      //                  interfaceRepo.deleteCustom("a1").subscribe(System.out::println);

      //                  interfaceRepo.saveAll(List.of(
      //                      Post.builder()
      //                      .title("1111111111111")
      //                      .content("22222222222222")
      //                      .build(),
      //                      Post.builder()
      //                      .title("1111111111111")
      //                      .content("22222222222222")
      //                      .build())).subscribe(System.out::println);

      //                  interfaceRepo.findAll().subscribe(System.out::println);

      //
      // interfaceRepo.existsById(UUID.randomUUID()).subscribe(System.out::println);
      //
      //       interfaceRepo.existsById(UUID.fromString("3e6bd218-4bc9-49a5-862f-a8cb312b8294"))
      //                      .subscribe(System.out::println);

      //      interfaceRepo.save(Post.builder()
      //          .title("a1")
      //          .content("b2")
      //          .build()).flatMap(interfaceRepo::delete).subscribe();

      //      interfaceRepo.findById(UUID.fromString("f5d5cd42-831c-4c43-af12-ae225069c93f"))
      //          .flatMap(interfaceRepo::delete).doOnEach(System.out::println).subscribe();
      //      postRepository1.delete(block).subscribeAsCompletionStage().get();

      //
      //      interfaceRepo.save(Post.builder()
      //          .title("a1")
      //          .content("b2")
      //          .build())
      //          .flatMap(p -> interfaceRepo.deleteById(p.getId()))
      //                      .doOnSuccess(System.out::println).subscribe();
      //
      // interfaceRepo.deleteById(UUID.fromString("ac1625f1-57fe-46bf-9687-a11944b465f9")).subscribe();
      //
      //
      // interfaceRepo.deleteAllById(List.of(UUID.fromString("f6618cdc-b748-45b4-be08-e9bd990129f9"),
      //                      UUID.fromString("43022da0-d025-42c1-90b1-00b1d23d037b"),
      // UUID.randomUUID()))
      //                      .doOnSuccess(System.out::println).subscribe();
      //                  interfaceRepo.findAllById(List.of(
      //                      UUID.fromString("000df430-bd15-4940-8a5d-c7f21e488cc2"),
      //                      UUID.fromString("1cdda162-d113-4fc4-b141-4b37d1d6d75e"),
      //                      UUID.randomUUID(),
      //                      UUID.fromString("b573d8fe-9c72-46bb-b497-830f53b4357d")
      //                  )).collectList().flatMap(interfaceRepo::deleteAll)
      //                      .doOnSuccess(System.out::println).subscribe();

      //                  interfaceRepo.findAll(Sort.by(Sort.Order.asc("createdAt")))
      //                      .subscribe(System.out::println);
    };
  }
}
