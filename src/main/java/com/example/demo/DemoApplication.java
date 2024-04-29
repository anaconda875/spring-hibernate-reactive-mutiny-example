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
  CommandLineRunner testRepo(PostRepository interfaceRepo) {
    return args -> {
      //            interfaceRepo.findById(
      //                UUID.fromString("ea7d52c9-0754-4820-856e-ef7cb8571dd8"))
      //                .subscribe(System.out::println);
      //            interfaceRepo.findAllById(
      //                List.of(UUID.fromString("ea7d52c9-0754-4820-856e-ef7cb8571dd8"),
      //                        UUID.fromString("d1736c74-0b12-410f-bf5a-5ac776b56aaa"),
      //                        UUID.randomUUID(),
      //                        UUID.fromString("26c6c345-33bb-46a3-830b-f534fe8989ee")))
      //                .subscribe(System.out::println);
      //            interfaceRepo.count().subscribe(System.out::println);

      //            interfaceRepo.save(Post.builder()
      //                .title("a1")
      //                .content("b2")
      //                .build()).subscribe(System.out::println, System.err::println);
      //            interfaceRepo.save(Post.builder()
      //                .title("a1")
      //                .content("b2")
      //                .build()).subscribe(System.out::println, System.err::println);
      //            interfaceRepo.save(Post.builder()
      //                .title("tit")
      //                .content("content")
      //                .build()).subscribe(System.out::println, System.err::println);

      //
      // interfaceRepo.findByContentOrderByCreatedAt("content").subscribe(System.out::println);
      //            interfaceRepo.custom("tit").subscribe(System.out::println);
      //            interfaceRepo.custom2("contentttttttttttt").subscribe(System.out::println);

      //            interfaceRepo.nativeQ2("content")
      //                .subscribe(System.out::println);

      //            interfaceRepo.testNamedQuery("content").subscribe(System.out::println);

      //
      // interfaceRepo.existsById(UUID.fromString("3e6bd218-4bc9-49a5-862f-a8cb312b8294"))
      //                .subscribe(System.out::println);
      //
      //            interfaceRepo.countByTitleOrContent("tit555", "new
      // content").subscribe(System.out::println);

      //            interfaceRepo.update(UUID.fromString("3e6bd218-4bc9-49a5-862f-a8cb312b8294"),
      // "new content")
      //                .subscribe(System.out::println);

      //
      // interfaceRepo.updateNative(UUID.fromString("3e6bd218-4bc9-49a5-862f-a8cb312b8294"), "new
      // titttttt")
      //                .subscribe(System.out::println);

      //            interfaceRepo.deleteByTitle("Hello Spring").subscribe(System.out::println);

      //            interfaceRepo.deleteNative("new titttttt").subscribe(System.out::println);
      //
      // interfaceRepo.deleteNative2("contentttttttttttt").subscribe(System.out::println);
      //            interfaceRepo.deleteCustom("titttttttt").subscribe(System.out::println);

      //            interfaceRepo.saveAll(List.of(
      //                Post.builder()
      //                .title("tit1")
      //                .content("content1")
      //                .build(),
      //                Post.builder()
      //                .title("tit1")
      //                .content("content1")
      //                .build())).subscribe(System.out::println);

      //            interfaceRepo.findAll().subscribe(System.out::println);

      //            interfaceRepo.existsById(UUID.randomUUID()).subscribe(System.out::println);
      //
      // interfaceRepo.existsById(UUID.fromString("3e6bd218-4bc9-49a5-862f-a8cb312b8294"))
      //                .subscribe(System.out::println);

      //            interfaceRepo.findById(UUID.fromString("e78507a5-567b-4b0f-b0d4-1df47831696a"))
      //
      // .flatMap(interfaceRepo::delete).doOnSuccess(System.out::println).subscribe();
      //
      // interfaceRepo.deleteById(UUID.fromString("f116838f-b6b5-4612-ad3c-9cfac221fe01"))
      //                .doOnSuccess(System.out::println).subscribe();
      //
      // interfaceRepo.deleteAllById(List.of(UUID.fromString("6f3402ff-d0e9-44e9-ad93-7dbd91631a0f"),
      //                UUID.fromString("a6c73c82-ed4e-4e64-9a93-055a5fc5ee17"), UUID.randomUUID()))
      //                .doOnSuccess(System.out::println).subscribe();
      //            interfaceRepo.findAllById(List.of(
      //                UUID.fromString("11fd965f-8e13-4130-a1c7-713185c62b20"),
      //                UUID.randomUUID(),
      //                UUID.fromString("462233f9-66aa-4f93-994b-b8bfd6631783")
      //            )).collectList().flatMap(interfaceRepo::deleteAll)
      //                .doOnSuccess(System.out::println).subscribe();

      //            interfaceRepo.findAll(Sort.by(Sort.Order.asc("createdAt")))
      //                .subscribe(System.out::println);
    };
  }
}
