package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.repo.MovieRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService{

    MovieRepo movieRepo;

    @Autowired
    public MovieServiceImp(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public List<MovieDTO> getByDateRange(LocalDate startRange, LocalDate endRange) {
        List<Movie> list = movieRepo.getAllByRange(startRange, endRange);
        return MovieDTO.entityToDTO(list);
    }
}
