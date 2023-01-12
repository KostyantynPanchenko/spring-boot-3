package com.example.springboot3.exception;

public class AlbumNotFoundException extends RuntimeException {

  private final Integer id;

  public AlbumNotFoundException(final Integer id) {
    super("Album with id=" + id + " not found");
    this.id = id;
  }

  public Integer getId() {
    return id;
  }
}
