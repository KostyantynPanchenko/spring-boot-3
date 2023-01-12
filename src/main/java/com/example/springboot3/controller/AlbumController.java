package com.example.springboot3.controller;

import com.example.springboot3.model.Album;
import com.example.springboot3.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class AlbumController {

  private final AlbumService service;

  @GetMapping("albums/{id}")
  Album getById(@PathVariable final Integer id) {
    return service.getAlbumById(id);
  }

}
