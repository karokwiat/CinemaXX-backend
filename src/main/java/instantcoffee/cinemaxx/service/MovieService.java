package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.entities.Movie;

public interface MovieService {

    public MovieDTO createMovie(Movie movie);
    MovieDTOCustomer getById(int id);
}
