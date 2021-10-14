package instantcoffee.cinemaxx.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "movies")
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


    @ManyToMany(mappedBy = "theaterHallsHasMovies", cascade = CascadeType.REMOVE)
    private Set<TheaterHall> theaterHallsHasMovies;

    @ManyToMany
    @JoinTable(
            name = "actors_has_movies",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actorsHasMovies;

}
