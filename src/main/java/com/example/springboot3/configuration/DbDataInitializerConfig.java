package com.example.springboot3.configuration;

import com.example.springboot3.service.AlbumService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
class DbDataInitializerConfig {

  private final ObservationRegistry observationRegistry;

  @Bean
  CommandLineRunner populateTheDatabase(final AlbumService albumService) {
    return (String... args) -> {
      log.info("Fetching albums from remote...");
      final var albums = Observation
          .createNotStarted("db-initialization.fetch-from-remote", observationRegistry)
          .observe(albumService::fetchAllFromRemoteOrigin);
      log.info("Albums fetched.");
      log.info("Saving albums...");
      Observation
          .createNotStarted("db-initialization.save-all", observationRegistry)
          .observe(() -> albumService.saveAll(albums));
      log.info("Albums saved.");
    };
  }

}
