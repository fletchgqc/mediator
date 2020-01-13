package com.example.mediator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    private Long id;
    private String title;
    private String duration;

    public Movie() {

    }

    public Movie(String title, String duration) {
        //this.id = UUID.randomUUID().toString();
        this.title = title;
        this.duration = duration;
    }
}
