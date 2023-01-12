package com.example.springboot3.configuration;

import com.example.springboot3.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class DbDataInitializerConfig {

  @Bean
  CommandLineRunner populateTheDatabase(final AlbumService albumService) {
    return (String... args) -> {
      log.info("Fetching albums from remote...");
      final var albums = albumService.fetchAllFromRemoteOrigin();
      log.info("Albums fetched.");
      log.info("Saving albums...");
      albumService.saveAll(albums);
      log.info("Albums saved.");
    };
  }

}
