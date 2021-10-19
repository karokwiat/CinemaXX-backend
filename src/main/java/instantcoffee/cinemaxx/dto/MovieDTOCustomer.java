package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Getter
@Setter
public class MovieDTOCustomer {
    private String title;
    private String description;
    private int ageRestriction;
    private int rating;
    private String image;
    private String poster;
    private String trailer;

    public MovieDTOCustomer(Movie movie) {
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.ageRestriction = movie.getAgeRestriction();
        this.rating = movie.getRating();
        this.image = movie.getImage();
        this.image = movie.getPoster();
        this.image = movie.getTrailer();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static MovieDTOCustomer entityToDTO(Movie movie) {
        MovieDTOCustomer movieDTO = modelMapper.map(movie, MovieDTOCustomer.class);
        return movieDTO;
    }

}
