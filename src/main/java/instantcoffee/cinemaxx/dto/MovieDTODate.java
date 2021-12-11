package instantcoffee.cinemaxx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import instantcoffee.cinemaxx.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTODate {

    private int movieId;
    private String title;
    private int ageRestriction;
    private String poster;
    private Set<TimeSlotDTO> timeSlots;

    public MovieDTODate(int movieId, String title, int ageRestriction, String poster, Set<TimeSlotDTO> timeSlots) {
        this.movieId = movieId;
        this.title = title;
        this.ageRestriction = ageRestriction;
        this.poster = poster;
        this.timeSlots = timeSlots;
    }

    public static List<MovieDTODate> entityToDTO(List<Movie> movies) {
        return movies.stream()
                .map(x ->
                        new MovieDTODate(x.getMovieId(), x.getTitle(), x.getAgeRestriction(), x.getPoster(),
                            x.getTimeSlots().stream()
                        .map(c ->
                            new TimeSlotDTO(c.getTimeSlotId(), c.getScheduledTime()))
                        .collect(Collectors.toSet())))
                .collect(Collectors.toList());
    }
}
