package com.practice.demo.service;

import com.practice.demo.exception.InvalidDataFound;
import com.practice.demo.exception.NotFoundException;
import com.practice.demo.model.Movie;
import com.practice.demo.repo.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    //CRUD
    //Create
    public Movie create(Movie movie){
     if(movie==null){
         throw new InvalidDataFound("Movie not found");
     }
     return movieRepository.save(movie);
    }
    public Movie read(Long Id){

        return movieRepository.findById(Id).orElseThrow(() -> new NotFoundException("Movie Not Found exception"));
    }
    public void update (Long Id,Movie update){
        if(update==null){
            throw new InvalidDataFound("Movie not found:"+Id);
        }
        if(movieRepository.existsById(Id)){
           Movie movie =movieRepository.getReferenceById(Id);
            movie.setName(update.getName());
            movie.setActors(update.getActors());
            movie.setDirector(update.getDirector());
            movieRepository.save(movie);
        }
    }
    public void delete (Long Id){

        if(movieRepository.existsById(Id)){
            movieRepository.deleteById(Id);
        }else{
            throw new NotFoundException("Movie not Found for delete:"+Id);
        }
    }

}
