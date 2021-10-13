package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface MovieController {

    @GetMapping("/{id}")
    MovieDTOCustomer getMovieInfo(@PathVariable("id") int id);
}
