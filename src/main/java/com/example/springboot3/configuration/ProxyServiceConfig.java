package com.example.springboot3.configuration;

import com.example.springboot3.webclient.AlbumWebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
class ProxyServiceConfig {

  @Bean
  AlbumWebClient albumWebClient(final WebClient webClient) {
    final var factory = HttpServiceProxyFactory
        .builder(WebClientAdapter.forClient(webClient))
        .build();
    return factory.createClient(AlbumWebClient.class);
  }

}
