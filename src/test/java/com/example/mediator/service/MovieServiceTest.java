package com.example.mediator.service;

import com.example.mediator.domain.Movie;
import com.example.mediator.repository.MovieRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MovieServiceTest {

    private MovieRepository movieRepository = mock(MovieRepository.class);
    private MovieService movieService = new MovieService(movieRepository);

    @Test
    public void whenNoMoviesGivenFailGracefully(){
        when(movieRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        assertEquals(null, movieService.getMovie());
    }

    @Test
    public void recommendMovieWhenMoviesAreAvailable(){
        List<Movie> movies = Arrays.asList(new Movie("some movie", "1h"), new Movie("some other movie", "2h"));
        when(movieRepository.findAll()).thenReturn(movies);
        assertThat(movieService.getMovie()).isIn(movies);
    }
}
