package com.example.springboot3.model;

public class AlbumNotFoundProblem {

  private final String desc;

  public AlbumNotFoundProblem() {
    this.desc = "AlbumNotFoundException is thrown when album with specified id was not found";
  }

  public String getDesc() {
    return desc;
  }
}
