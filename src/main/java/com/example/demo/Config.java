package com.example.demo;

import com.htech.data.jpa.reactive.config.EnableReactiveJpaAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.spel.spi.EvaluationContextExtension;
import org.springframework.data.spel.spi.ReactiveEvaluationContextExtension;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;
import reactor.core.publisher.Mono;

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
    //    return AuthorityContextHolder::get;
    return () ->
        ReactiveSecurityContextHolder.getContext()
            .map(SecurityContext::getAuthentication)
            .map(Authentication::getPrincipal)
            .map(UserDetails.class::cast)
            .map(UserDetails::getUsername);
  }

  @Bean
  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http.csrf(ServerHttpSecurity.CsrfSpec::disable)
        .authorizeExchange(authorize -> authorize.anyExchange().authenticated())
        .httpBasic(Customizer.withDefaults())
        .build();
  }

  @Bean
  ReactiveUserDetailsService userDetailsService() {
    var isabelle = User.withUsername("admin").password("admin").authorities("admin").build();

    var bjorn =
        User.withUsername("anonymous").password("anonymous").authorities("anonymous").build();

    return new MapReactiveUserDetailsService(isabelle, bjorn);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  ReactiveEvaluationContextExtension securityExtension() {
    return new ReactiveEvaluationContextExtension() {

      @Override
      public String getExtensionId() {
        return "webflux-security";
      }

      @Override
      public Mono<? extends EvaluationContextExtension> getExtension() {
        return ReactiveSecurityContextHolder.getContext()
            .map(SecurityContext::getAuthentication)
            .map(SecurityEvaluationContextExtension::new);
      }

      //			@Override
      //			public Mono<? extends EvaluationContextExtension> getExtension() {
      //				return Mono.defer(() -> ReactiveSecurityContextHolder.getContext()
      //						.map(SecurityContext::getAuthentication)
      //						.map(SecurityEvaluationContextExtension::new));
      //			}
    };
  }
}
