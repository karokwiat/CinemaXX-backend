package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieControllerImp implements MovieController{

    MovieService movieService;

    @Autowired
    public MovieControllerImp(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public MovieDTOCustomer getMovieInfo(@PathVariable ("id") int id){
        return movieService.getById(id);
    }

    @PostMapping
    public MovieDTO postMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }


}
