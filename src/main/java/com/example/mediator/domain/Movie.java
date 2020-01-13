package com.example.mediator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String duration;

    protected Movie() {
    }

    public Movie(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }


}
