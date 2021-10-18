package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.Actor;
import instantcoffee.cinemaxx.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@NoArgsConstructor
@Getter
@Setter
public class MovieDTOCustomer {
    private String title;
    private String description;
    private int ageRestriction;
    private int rating;
    List<ActorDTO> actors; // = new ArrayList<>();
    String[] actorsNames = null;


    public MovieDTOCustomer(Movie movie) {
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.ageRestriction = movie.getAgeRestriction();
        this.rating = movie.getRating();
        actors = movie.getActors().stream().map(actor -> new ActorDTO(actor.getFirstName(), actor.getLastName())).collect(Collectors.toList());
    }

    public MovieDTOCustomer(String title, String description, int ageRestriction, int rating, String[] actors){
        this.title = title;
        this.description = description;
        this.ageRestriction = ageRestriction;
        this.rating = rating;
        actorsNames = actors;
    }

    public static List<MovieDTOCustomer> getListFromMovieList(Iterable<Movie> movies){
        List<MovieDTOCustomer> movieDTOS = new ArrayList<>();
        for(Movie m: movies){
            movieDTOS.add(new MovieDTOCustomer((m)));
        }
        return movieDTOS;
    }

    public static List<MovieDTOCustomer> getListFromMovieListWithActorsNames(Iterable<Movie> movies){
        List<MovieDTOCustomer> dtos = new ArrayList<>();
        for(Movie movie : movies){
            String[] actors = movie.getActors().stream().map(actor -> actor.getFirstName()).collect(Collectors.toList()).toArray(new String[0]);
            dtos.add(new MovieDTOCustomer(movie.getTitle(), movie.getDescription(), movie.getAgeRestriction(), movie.getRating(), actors));
        }
        return dtos;
    }


    private static ModelMapper modelMapper = new ModelMapper();

    public static MovieDTOCustomer entityToDTO(Movie movie) {
        MovieDTOCustomer movieDTO = modelMapper.map(movie, MovieDTOCustomer.class);
        return movieDTO;
    }

    public static List<MovieDTOCustomer> entityToDTO(List<Movie> movies) {
        return movies.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }
}
