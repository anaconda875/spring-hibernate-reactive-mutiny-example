package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class AuthorityFilter implements WebFilter {

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    HttpHeaders headers = exchange.getRequest().getHeaders();
    return chain
        .filter(exchange)
        .contextWrite(
            AuthorityContextHolder.set(
                headers.containsKey("X-Requested-By")
                    ? headers.get("X-Requested-By").stream().findFirst().orElse("anonymous")
                    : "anonymous"));
  }
}
