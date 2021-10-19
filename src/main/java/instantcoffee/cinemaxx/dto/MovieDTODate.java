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

    private String title;
    private int ageRestriction;
    private Set<TimeSlotDTO> timeSlots;

    public MovieDTODate(String title, int ageRestriction, Set<TimeSlotDTO> timeSlots) {
        this.title = title;
        this.ageRestriction = ageRestriction;
        this.timeSlots = timeSlots;
    }

    public static List<MovieDTODate> entityToDTO(List<Movie> movies) {
        return movies.stream()
                .map(x ->
                        new MovieDTODate(x.getTitle(), x.getAgeRestriction(),
                            x.getTimeSlots().stream()
                        .map(c ->
                            new TimeSlotDTO(c.getScheduledTime()))
                        .collect(Collectors.toSet())))
                .collect(Collectors.toList());
    }
}
