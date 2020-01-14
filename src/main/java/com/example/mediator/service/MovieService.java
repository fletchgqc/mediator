package com.example.mediator.service;

import com.example.mediator.domain.Movie;
import com.example.mediator.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovie() {
        return getRecommendedMovie();
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    private Movie getRecommendedMovie() {
        List<Movie> movies = getMovies();
        return movies.get(new Random().nextInt(movies.size()));
    }
}
