package com.example.demo;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class AuthorityContextHolder {

  public static final String AUTHORITY = "AUTHORITY";

  public static Context set(String authority) {
    return Context.of(AUTHORITY, Mono.just(authority));
  }

  public static Mono<String> get() {
    return Mono.deferContextual(
        c -> {
          if (c.hasKey(AUTHORITY)) {
            return c.get(AUTHORITY);
          }

          return Mono.empty();
        });
  }
}
