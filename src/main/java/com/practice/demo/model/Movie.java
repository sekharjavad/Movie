package com.practice.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String director;
    private List<String> actors =new ArrayList<>();
}
