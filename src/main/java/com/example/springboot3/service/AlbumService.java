package com.example.springboot3.service;

import com.example.springboot3.model.Album;
import com.example.springboot3.repository.AlbumRepository;
import com.example.springboot3.webclient.AlbumWebClient;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlbumService {

  private final AlbumWebClient webClient;
  private final AlbumRepository repository;

  public List<Album> fetchAllFromRemoteOrigin() {
    return webClient.getAll();
  }

  @Transactional
  public void saveAll(final List<Album> albums) {
    repository.saveAll(albums);
  }
}
