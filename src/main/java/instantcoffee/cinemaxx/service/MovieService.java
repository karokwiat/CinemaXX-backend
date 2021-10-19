package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.dto.MovieDTODate;
import instantcoffee.cinemaxx.entities.Movie;
import org.springframework.http.ResponseEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;


public interface MovieService {


    MovieDTO createMovie(Movie movie) throws Exception;
    MovieDTOCustomer getById(int id);
    List<MovieDTODate> getByDateRange(LocalDate startRange, LocalDate endRange);

    void delete(int id);

}
