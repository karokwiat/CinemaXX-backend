package instantcoffee.cinemaxx.controller;


import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.dto.MovieDTODate;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.repo.MovieRepo;
import instantcoffee.cinemaxx.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieControllerImp implements MovieController{

    MovieService movieService;
    MovieRepo movieRepo;

    @Autowired
    public MovieControllerImp(MovieService movieService, MovieRepo movieRepo){
        this.movieService = movieService;
        this.movieRepo = movieRepo;
    }

    @GetMapping("/{id}")
    public MovieDTOCustomer getMovieInfo(@PathVariable("id") int id){ return movieService.getById(id); }


    @Override
    public void deleteMovie(int id) {
        movieService.delete(id);
    }

    @Override
    public void editMovie(MovieDTO movie) {
        movieService.edit(movie);
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
    @Override
    public List<MovieDTODate> getAllByRange(LocalDate startRange, LocalDate endRange) {
        return movieService.getByDateRange(startRange, endRange);
    }
}
