package instantcoffee.cinemaxx.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "movies", schema = "cinemaxx")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_Id")
    private int movieId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "age_restriction")
    private int ageRestriction;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "rating")
    private int rating;

    @ManyToMany //(mappedBy= "theaterHallsHasMovies", cascade = CascadeType.REMOVE)
    @JoinTable(
            name="theater_halls_has_movies",
            joinColumns = @JoinColumn(name="movie_Id"),
            inverseJoinColumns = @JoinColumn(name = "time_slots_id")
    )
    private Set<TimeSlot> timeSlots;
}