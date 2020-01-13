package com.example.mediator.service;

import com.example.mediator.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.mediator.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    public Movie getMovie() {
        return getMovies().get(0);
    }
}
