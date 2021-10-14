package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter @Setter
public class MovieDTO {

    private String title;
    private int ageRestriction;


    public MovieDTO(Movie movie) {
        this.title = movie.getTitle();
        this.ageRestriction = movie.getAgeRestriction();

    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static MovieDTO entityToDTO(Movie movie) {
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
        return movieDTO;
    }

    public static List<MovieDTO> entityToDTO(List<Movie> movies) {
        return movies.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    private static Movie DTOtoEntity(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        return movie;
    }

    public static List<Movie> DTOtoEntity(List<MovieDTO> movieDTOS) {
        return movieDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }
}
