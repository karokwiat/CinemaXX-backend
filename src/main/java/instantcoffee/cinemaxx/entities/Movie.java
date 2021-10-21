package instantcoffee.cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
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

    @JsonIgnore
    @ManyToMany(mappedBy = "theaterHallsHasMovies", cascade = CascadeType.REMOVE)
    private Set<TheaterHall> theaterHallsHasMovies = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "actors_has_movies",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actorsHasMovies = new HashSet<>();

    public Set<Actor> getActors() {
        return actorsHasMovies;
    }

    @ManyToMany
    @JoinTable(
            name = "theater_halls_has_movies",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "time_slot_id"))
    private Set<TimeSlot> timeSlots = new HashSet<>();

}
