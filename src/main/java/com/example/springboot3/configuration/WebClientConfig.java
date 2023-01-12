package com.example.springboot3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class WebClientConfig {

  @Bean
  WebClient webClient() {
    return WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com/").build();
  }

}