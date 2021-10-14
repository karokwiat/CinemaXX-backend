package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.error.ResourceNotFoundException;
import instantcoffee.cinemaxx.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class MovieServiceImp implements MovieService{

    MovieRepo movieRepo;

    private String errorMessage(long id){
        return "Not found Movie with id = " + id;
    }

    @Autowired
    public MovieServiceImp (MovieRepo movieRepo){
        this.movieRepo = movieRepo;
    }

    @Override
    public MovieDTO createMovie(Movie movie) throws Exception {

        LocalDate d1 = movie.getStartDate();
        LocalDate d2 = movie.getEndDate();

        if (d1.compareTo(d2) > 0 || d1.compareTo(d2) == 0 ){
            throw new Exception("no bueno");
        }
        movieRepo.save(movie);
        return MovieDTO.entityToDTO(movie);
    }

    @Override
    public MovieDTOCustomer getById(int id) {
        return MovieDTOCustomer.entityToDTO(movieRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(id))));
    }

    @Override
    public void delete(int id) {
        Movie movie = movieRepo.getById(id);
        movieRepo.delete(movie);
    }
}
