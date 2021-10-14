package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieControllerImp implements MovieController {

    MovieService movieService;

    @Autowired
    public MovieControllerImp(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public List<MovieDTO> getAllByRange(LocalDate startRange, LocalDate endRange) {
        return movieService.getByDateRange(startRange, endRange);
    }
}
