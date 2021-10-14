package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class MovieServiceImp implements MovieService{

    MovieRepo movieRepo;

    @Autowired
    public MovieServiceImp (MovieRepo movieRepo){
        this.movieRepo = movieRepo;
    }

    @Override
    public MovieDTO createMovie(Movie movie) {
        Movie movie1 = movieRepo.save(movie);
        LocalDate d1 = movie1.getStartDate();
        LocalDate d2 = movie1.getEndDate();
        //if (d1.compareTo(d2) > 0 || d1.compareTo(d2) == 0 ){}
        return MovieDTO.entityToDTO(movie1);
    }

    @Override
    public MovieDTOCustomer getById(int id) {
        return MovieDTOCustomer.entityToDTO(movieRepo.findById(id));
    }
}
