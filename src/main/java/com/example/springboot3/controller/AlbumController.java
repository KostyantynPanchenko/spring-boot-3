package com.example.springboot3.controller;

import com.example.springboot3.model.Album;
import com.example.springboot3.service.AlbumService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class AlbumController {

  private final AlbumService service;
  private final ObservationRegistry observationRegistry;

  @GetMapping("albums/{id}")
  Album getById(@PathVariable final Integer id) {
    return Observation.createNotStarted("album-service.get-one-by-id", observationRegistry)
        .lowCardinalityKeyValue("album-controller.method-name", "getAlbumById")
        .highCardinalityKeyValue("albumId", id.toString())
        .observe(() -> service.getAlbumById(id));
  }

  @GetMapping("albums")
  List<Album> getAll() {
    return Observation.createNotStarted("album-controller.get-all", observationRegistry)
        .lowCardinalityKeyValue("album-controller.method-name", "getAll")
        .observe(service::getAll);
  }
}
