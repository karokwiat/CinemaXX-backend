package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.dto.MovieDTODate;
import instantcoffee.cinemaxx.entities.Movie;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public interface MovieController {

    @GetMapping("/{id}")
    MovieDTOCustomer getMovieInfo(@PathVariable("id") int id);

    @PostMapping
    ResponseEntity<String> postMovie(@RequestBody Movie movie);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id);

    @PutMapping
    public ResponseEntity<String> editMovie(@RequestBody MovieDTO movie);

    @GetMapping
    List<MovieDTODate> getAllByRange(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startRange, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endRange);

}
