package com.example.demo;

import com.htech.data.jpa.reactive.config.EnableReactiveJpaAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

@Configuration
@EnableReactiveJpaAuditing(auditorAwareRef = "reactiveAuditorAware")
public class Config {

  @Bean
  WebFluxConfigurer webFluxConfigurer() {
    return new WebFluxConfigurer() {
      @Override
      public void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
        configurer.addCustomResolver(new ReactivePageableHandlerMethodArgumentResolver());
      }
    };
  }

  @Bean
  ReactiveAuditorAware<String> reactiveAuditorAware() {
    return AuthorityContextHolder::get;
  }
}
