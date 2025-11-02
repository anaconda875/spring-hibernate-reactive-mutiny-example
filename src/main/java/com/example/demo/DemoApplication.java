package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
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
//
//                        interfaceRepo.findById(
//                            UUID.fromString("ea7d52c9-0754-4820-856e-ef7cb8571dd8"))
//                            .subscribe(System.out::println);
//                        interfaceRepo.findAllById(
//                            List.of(UUID.fromString("ea7d52c9-0754-4820-856e-ef7cb8571dd8"),
//                                    UUID.fromString("d1736c74-0b12-410f-bf5a-5ac776b56aaa"),
//                                    UUID.randomUUID(),
//                                    UUID.fromString("26c6c345-33bb-46a3-830b-f534fe8989ee")))
//                            .subscribe(System.out::println);
//                        interfaceRepo.count().subscribe(System.out::println);
//
//                  interfaceRepo.save(Post.builder()
////                      .title("tit")
//                      .content("test null tit")
//                      .build()).subscribe(System.out::println, e -> e.printStackTrace());
//
//
//
//

//       interfaceRepo.findByContentOrderByCreatedAtDesc("content1").subscribe(System.out::println);
//                              interfaceRepo.custom("trans").subscribe(System.out::println);
//                              interfaceRepo.custom1("tit1").subscribe(System.out::println);
//                              interfaceRepo.custom2("content").subscribe(System.out::println);
//                              interfaceRepo.custom3("au").subscribe(System.out::println);
//
//                                    interfaceRepo.nativeQ2("trans")
//                                        .subscribe(System.out::println);
//                  interfaceRepo.nativeQ(UUID.fromString("c82c174e-2ae8-4ef3-a87b-c258222e991e"))
//                      .subscribe(System.out::println);
//
//                        interfaceRepo.testNamed("content", Pageable.unpaged()).subscribe(page -> System.out.println(page.getContent()));

//             interfaceRepo.existsById(UUID.randomUUID())
//                            .subscribe(System.out::println);
//            interfaceRepo.existsById(UUID.fromString("26dc7e31-5d12-4b71-8110-28c89241361d"))
//                .subscribe(System.out::println);
//
//                              interfaceRepo.countByTitleOrContent("tit",
//             "trans").subscribe(System.out::println);
//
//
//             interfaceRepo.update(UUID.fromString("ea8aa4fc-89d9-439c-a742-a22fed6923a5"),
//                   "a1").subscribe(System.out::println);
//
//       interfaceRepo.updateNative(UUID.fromString("ea7d52c9-0754-4820-856e-ef7cb8571dd8"),
//             "content").subscribe(System.out::println);

//      Mono<Post> save = interfaceRepo.save(Post.builder()
//                .title("a1")
//                .content("b2")
//                .build());
//
//            save
//                            .flatMap(i -> Mono.error(new RuntimeException(i.getTitle())))
//                            .subscribe(System.out::println);
//                              interfaceRepo.save(Post.builder()
//                                  .title("a1")
//                                  .content("b2")
//                                  .build()).subscribe(System.out::println, System.err::println);
//
//                              interfaceRepo.deleteByTitle("a1").subscribe(System.out::println);
//
//                              interfaceRepo.deleteNative("b2").subscribe(System.out::println);
//
//                   interfaceRepo.deleteNative2("b2").subscribe(System.out::println);
//                              interfaceRepo.deleteCustom("a1").subscribe(System.out::println);
//
//                              interfaceRepo.saveAll(List.of(
//                                  Post.builder()
//                                  .title("1111111111111")
//                                  .content("22222222222222")
//                                  .build(),
//                                  Post.builder()
//                                  .title("3333")
//                                  .content("4444")
//                                  .build())).subscribe(System.out::println);
//
//                              interfaceRepo.findAll().subscribe(System.out::println);
//
//
//       interfaceRepo.existsById(UUID.randomUUID()).subscribe(System.out::println);
//
//             interfaceRepo.existsById(UUID.fromString("3e6bd218-4bc9-49a5-862f-a8cb312b8294"))
//                            .subscribe(System.out::println);
//
//            interfaceRepo.save(Post.builder()
//                .title("a1")
//                .content("b2")
//                .build()).flatMap(interfaceRepo::delete).subscribe();
//
//            interfaceRepo.findById(UUID.fromString("f5d5cd42-831c-4c43-af12-ae225069c93f"))
//                .flatMap(interfaceRepo::delete).doOnEach(System.out::println).subscribe();
//            postRepository1.delete(block).subscribeAsCompletionStage().get();
//
//
//            interfaceRepo.save(Post.builder()
//                .title("a1")
//                .content("b2")
//                .build())
//                .flatMap(p -> interfaceRepo.deleteById(p.getId()))
//                            .doOnSuccess(System.out::println).subscribe();
//
//
//
//

//      interfaceRepo.save(Post.builder()
//                .title("a1")
//                .content("b2")
//                .build()).doOnSuccess(System.out::println).subscribe();
//      interfaceRepo.save(Post.builder()
//          .title("a1")
//          .content("b2")
//          .build()).doOnSuccess(System.out::println).subscribe();
//      interfaceRepo.save(Post.builder()
//          .title("a1")
//          .content("b2")
//          .build()).doOnSuccess(System.out::println).subscribe();

       interfaceRepo.deleteById(UUID.fromString("5d88fea6-40d1-4390-ad8c-60d13d4374a3"))
           .doOnSuccess(e -> System.out.println("System.out::println11111111111111")).subscribe();
       interfaceRepo.deleteAllById(List.of(UUID.fromString("bc8f456b-2428-4be9-bbd6-0f1fba912504"),
                            UUID.fromString("55eef44d-c017-4770-9331-e75f9aa9990e"),
       UUID.randomUUID()))
                            .doOnSuccess(e -> System.out.println("222222222222222")).subscribe();
//                              interfaceRepo.findAllById(List.of(
//                                  UUID.fromString("49994a31-089e-4626-ab1f-6327be1c032f"),
//                                  UUID.fromString("f80d52bb-8e9d-4194-9766-febd9ee78257"),
//                                  UUID.randomUUID()
//                              )).collectList().flatMap(interfaceRepo::deleteAll)
//                                  .doOnSuccess(System.out::println).subscribe();
//
//                              interfaceRepo.findAll(Sort.by(Sort.Order.desc("createdAt")))
//                                  .subscribe(System.out::println);
//
//            interfaceRepo.testSpel("trans").subscribe(System.out::println);
//            interfaceRepo
//                .testNamed("content", PageRequest.of(1, 2))
//                .subscribe(p -> System.out.println(p.getContent()));


//      interfaceRepo.findOne((root, query, cb) -> cb.equal(root.get("id"), UUID.randomUUID()))
//          .subscribe(System.out::println);
//      interfaceRepo.findOne((root, query, cb) -> cb.equal(root.get("id"), UUID.fromString("26dc7e31-5d12-4b71-8110-28c89241361d")))
//          .subscribe(System.out::println);
//      interfaceRepo.findAll((root, query, cb) -> cb.and(cb.equal(root.get("title"), "trans"), cb.equal(root.get("createdBy"), "anonymous")))
//          .subscribe(System.out::println);
//      interfaceRepo.findAll((root, query, cb) -> cb.and(cb.equal(root.get("title"), "tit1")), Sort.by(Sort.Order.desc("createdAt")))
//          .subscribe(System.out::println);
//      interfaceRepo.findAll((root, query, cb) -> cb.and(cb.equal(root.get("title"), "tit1")), PageRequest.of(0, 2, Sort.by(Sort.Order.desc("createdAt"))))
//          .subscribe(page -> page.getContent().forEach(System.out::println));
//      interfaceRepo.count((root, query, cb) -> cb.and(cb.equal(root.get("title"), "trans"), cb.equal(root.get("createdBy"), "admin")))
//          .subscribe(System.out::println);
//      interfaceRepo.exists((root, query, cb) -> cb.and(cb.equal(root.get("title"), "transsssss")))
//          .subscribe(System.out::println);
//      interfaceRepo.delete((root, query, cb) -> cb.and(cb.equal(root.get("title"), "a1"),
//              cb.equal(root.get("content"), "b2")))
//          .subscribe(System.out::println);
    };
  }
}
