package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImp implements MovieService{

    MovieRepo movieRepo;

    @Autowired
    public MovieServiceImp (MovieRepo movieRepo){
        this.movieRepo = movieRepo;
    }

    @Override
    public MovieDTOCustomer getById(int id) {
        return MovieDTOCustomer.entityToDTO(movieRepo.findById(id).get());
    }

    @Override
    public void delete(int id) {
        Movie movie = movieRepo.getById(id);
        movieRepo.delete(movie);
    }

    @Override
    public void edit(MovieDTO movie) {
        Movie newMovie = MovieDTO.DTOtoEntity(movie);
        Movie oldMovie = movieRepo.findById(movie.getMovieId()).get();
        if(newMovie.getTitle().isEmpty())
            newMovie.setTitle(oldMovie.getTitle());
        if(newMovie.getAgeRestriction() == 0)
            newMovie.setAgeRestriction(oldMovie.getAgeRestriction());
        if(newMovie.getDescription().isEmpty())
            newMovie.setDescription(oldMovie.getDescription());
        if(newMovie.getStartDate() == null)
            newMovie.setStartDate(oldMovie.getStartDate());
        if(newMovie.getEndDate() == null)
            newMovie.setEndDate(oldMovie.getEndDate());
        if(newMovie.getRating() == 0)
            newMovie.setRating(oldMovie.getRating());
        movieRepo.save(newMovie);
    }
}
