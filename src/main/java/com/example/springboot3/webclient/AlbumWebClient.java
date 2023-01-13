package com.example.springboot3.webclient;

import com.example.springboot3.model.Album;
import java.util.List;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "albums")
public interface AlbumWebClient {

  @GetExchange
  List<Album> getAll();

}
