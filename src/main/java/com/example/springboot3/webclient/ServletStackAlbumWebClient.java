package com.example.springboot3.webclient;

import com.example.springboot3.model.Album;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
class ServletStackAlbumWebClient implements AlbumWebClient {

  private final RestTemplate restTemplate;

  @Override
  public List<Album> getAll() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("accept", "application/json");
    return restTemplate.exchange("https://jsonplaceholder.typicode.com/albums",
        HttpMethod.GET,
        new HttpEntity<>(null, headers),
        new ParameterizedTypeReference<List<Album>>() {})
        .getBody();
  }

}
