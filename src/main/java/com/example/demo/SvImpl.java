package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SvImpl implements Sv {

  final PostRepository repository;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Mono<Post> test(String str) {
    return repository.testSpelNative2(str);
  }
}
