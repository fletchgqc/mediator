package com.example.mediator.endpoint;

import com.example.mediator.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mediator.service.MovieService;

@RestController
public class MovieController {

  @Autowired
  private MovieService movieService;

  @GetMapping("/movies")
  public Movie getRecommendation() {
    return movieService.getMovie();
  }
}
