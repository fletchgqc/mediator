package com.example.mediator;

import com.example.mediator.domain.Movie;
import com.example.mediator.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MediatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MovieRepository repository) {
		return (args) -> {
			repository.save(new Movie("Inception", "2h 28m"));
			repository.save(new Movie("Source code", "1h 33m"));
			repository.save(new Movie("Forest Gump", "2h 22m"));
			repository.save(new Movie("Source code", "1h 33m"));
			repository.save(new Movie("Source code", "1h 33m"));
			repository.save(new Movie("Source code", "1h 33m"));
			repository.save(new Movie("Source code", "1h 33m"));
			repository.save(new Movie("Source code", "1h 33m"));
		};
	}
}
