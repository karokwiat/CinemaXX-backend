package instantcoffee.cinemaxx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import instantcoffee.cinemaxx.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

    private int movieId;
    private String title;
    private String description;
    private int ageRestriction;
    private LocalDate startDate;
    private LocalDate endDate;
    private int rating;

    public MovieDTO(Movie movie) {
        this.movieId = movie.getMovieId();
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.ageRestriction = movie.getAgeRestriction();
        this.startDate = movie.getStartDate();
        this.endDate = movie.getEndDate();
        this.rating = movie.getRating();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static MovieDTO entityToDTO(Movie movie) {
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
        return movieDTO;
    }

    public static List<MovieDTO> entityToDTO(List<Movie> movies) {
        return movies.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Movie DTOtoEntity(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        return movie;
    }

    public static List<Movie> DTOtoEntity(List<MovieDTO> movieDTOS) {
        return movieDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }
}
