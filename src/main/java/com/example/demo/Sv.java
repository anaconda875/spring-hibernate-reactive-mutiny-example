package com.example.demo;

import reactor.core.publisher.Mono;

public interface Sv {

  Mono<Post> test(String str);

}
