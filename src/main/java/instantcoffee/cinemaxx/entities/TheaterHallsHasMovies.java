package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "theater_halls_has_movies")
public class TheaterHallsHasMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_hall_id")
    private int theaterHallId;
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "time_slots_id")
    private int timeSotsId;

    @ManyToOne
    TimeSlot timeSlot;
    @ManyToOne
    Movie movie;
    @ManyToOne
    TheaterHall theaterHall;
}
