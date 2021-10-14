package instantcoffee.cinemaxx.controller;


import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/movie")
public class MovieControllerImp implements MovieController{

    MovieService movieService;

    @Autowired
    public MovieControllerImp(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public MovieDTOCustomer getMovieInfo(@PathVariable("id") int id){
        return movieService.getById(id);
    }


    @Override
    public void deleteMovie(int id) {
        movieService.delete(id);
    }
    @PostMapping
    public ResponseEntity<String> postMovie(@RequestBody Movie movie) {
        try {
            movieService.createMovie(movie);
            return ResponseEntity.ok("Movie successfully added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Starting date is after Ending date, please check.");
        }
    }
}
