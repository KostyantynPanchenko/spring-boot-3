package com.example.springboot3.controller;

import com.example.springboot3.model.Album;
import com.example.springboot3.service.AlbumService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
class AlbumController {

  private final AlbumService service;
  private final ObservationRegistry observationRegistry;

  @GetMapping("albums/{id}")
  Album getById(@PathVariable final Integer id) {
    log.info("Album with id={} requested", id);
    return service.getAlbumById(id);
  }

  @GetMapping("albums")
  List<Album> getAll() {
    return Observation.createNotStarted("album-controller.get-all", observationRegistry)
        .lowCardinalityKeyValue("album-controller.method-name", "getAll")
        .observe(service::getAll);
  }
}
