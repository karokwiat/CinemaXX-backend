package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.entities.Movie;
import org.springframework.http.ResponseEntity;

public interface MovieService {

    MovieDTO createMovie(Movie movie) throws Exception;
    MovieDTOCustomer getById(int id);
}
