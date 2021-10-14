package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.MovieDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


public interface MovieController {

    @GetMapping
    List <MovieDTO> getAllByRange(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startRange,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endRange);
}
