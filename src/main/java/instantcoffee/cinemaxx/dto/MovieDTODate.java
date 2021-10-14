package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter @Setter
public class MovieDTODate {
    private String title;
    private int ageRestriction;


    public MovieDTODate(Movie movie) {
        this.title = movie.getTitle();
        this.ageRestriction = movie.getAgeRestriction();

    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static MovieDTODate entityToDTO(Movie movie) {
        MovieDTODate movieDTODate = modelMapper.map(movie, MovieDTODate.class);
        return movieDTODate;
    }

    public static List<MovieDTODate> entityToDTO(List<Movie> movies) {
        return movies.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    private static Movie DTOtoEntity(MovieDTODate movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        return movie;
    }

    public static List<Movie> DTOtoEntity(List<MovieDTODate> movieDTOS) {
        return movieDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }
}
