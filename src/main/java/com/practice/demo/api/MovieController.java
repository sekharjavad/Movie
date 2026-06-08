package com.practice.demo.api;

import com.practice.demo.model.Movie;
import com.practice.demo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> movie(@PathVariable Long id){
        Movie movie= movieService.read(id);
        log.info("getmovie with "+ movie.getId());
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> movie(@RequestBody Movie movie){
        Movie Createdmovie= movieService.create(movie);
        log.info("Createdmovie with ID "+ Createdmovie.getId());
        return ResponseEntity.ok(Createdmovie);
    }

    @PutMapping("/{id}")
    public void updatemovie(@PathVariable Long id,@RequestBody Movie movie){
        log.info("Updatedmovie with ID "+ movie.getId());
        movieService.update(id,movie);
    }

    @DeleteMapping("/{id}")
    public void deletemovie(@PathVariable Long id){
        log.info("deletedmovie with ID "+ id);
        movieService.delete(id);
    }

}
