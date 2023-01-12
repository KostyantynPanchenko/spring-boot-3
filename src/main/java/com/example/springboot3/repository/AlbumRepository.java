package com.example.springboot3.repository;

import com.example.springboot3.model.Album;
import org.springframework.data.repository.ListCrudRepository;

public interface AlbumRepository extends ListCrudRepository<Album, Integer> {}
