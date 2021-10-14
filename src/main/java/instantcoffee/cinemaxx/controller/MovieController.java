package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface MovieController {

    @GetMapping("/{id}")
    public MovieDTOCustomer getMovieInfo(@PathVariable ("id") int id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id);

}
