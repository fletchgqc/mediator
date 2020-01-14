package com.example.mediator.endpoint;

import com.example.mediator.domain.Movie;
import com.example.mediator.endpoint.MovieController;
import com.example.mediator.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MovieControllerTest {

    private MovieService movieService = mock(MovieService.class);
    private MockMvc restMock = MockMvcBuilders.standaloneSetup(new MovieController(movieService)).build();

    @Test
    public void noRecommendationWithNoMovies() throws Exception {
        when(movieService.getMovie()).thenReturn(null);
        restMock.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist()); // empty content/json

    }

    @Test
    public void aRecommendationWithMovies() throws Exception {
        when(movieService.getMovie()).thenReturn(new Movie("a Movie", "1h"));
        restMock.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(content().json("{title: \"a Movie\", duration: \"1h\"}"));
    }
}
