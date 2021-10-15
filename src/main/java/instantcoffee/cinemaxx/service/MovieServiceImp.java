package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.dto.MovieDTODate;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.error.ResourceNotFoundException;
import instantcoffee.cinemaxx.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
            throw new Exception("Starting date is after Ending date, please review.");
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
    @Override
    public List<MovieDTODate> getByDateRange(LocalDate startRange, LocalDate endRange) {
        List<Movie> list = movieRepo.getAllByRange(startRange, endRange);
        return MovieDTODate.entityToDTO(list);
    }
}
