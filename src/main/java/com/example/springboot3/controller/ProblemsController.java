package com.example.springboot3.controller;

import com.example.springboot3.model.AlbumNotFoundProblem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("problems")
public class ProblemsController {

  @GetMapping("album-not-found")
  AlbumNotFoundProblem albumNotFoundProblem() {
    return new AlbumNotFoundProblem();
  }
}
