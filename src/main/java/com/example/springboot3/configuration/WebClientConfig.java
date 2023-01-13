package com.example.springboot3.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class WebClientConfig {

//  Use with WebFlux only - need to change the dependency
//  @Bean
//  WebClient webClient() {
//    return WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com/").build();
//  }

  @Bean
  RestTemplate restTemplate(final RestTemplateBuilder builder) {
    return builder.build();
  }
}
