package com.example.springboot3.exception.handler;

import com.example.springboot3.exception.AlbumNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AlbumExceptionHandler {

  @ExceptionHandler(AlbumNotFoundException.class)
  public ProblemDetail handleAlbumNotFoundException(final AlbumNotFoundException exc)
      throws URISyntaxException {
    final var detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exc.getMessage());
    detail.setProperty("id", exc.getId());
    detail.setType(new URI("http://localhost:8080/problems/album-not-found"));
    return detail;
  }
}
