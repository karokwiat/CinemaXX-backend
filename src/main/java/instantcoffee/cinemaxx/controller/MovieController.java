package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.entities.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface MovieController {

    @GetMapping("/{id}")
    MovieDTOCustomer getMovieInfo(@PathVariable("id") int id);

    @PostMapping
    ResponseEntity<String> postMovie(@RequestBody Movie movie);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id);
}
