package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.entities.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    List<MovieDTO> getByDateRange(LocalDate startRange,LocalDate endRange);


}
