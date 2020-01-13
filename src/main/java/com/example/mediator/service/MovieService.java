package com.example.mediator.service;

import com.example.mediator.domain.Movie;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  List<Movie> movies = List.of(new Movie("Inception", "2h 28m"), new Movie("Interstellar", "2h 49m"));

  public List<Movie> getMovies() {
    return movies;
  }

  public Movie getMovie(){
    return movies.get(0);
  }
}
