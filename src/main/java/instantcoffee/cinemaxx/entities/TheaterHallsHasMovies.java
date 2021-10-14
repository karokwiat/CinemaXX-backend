package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "theaterHallsHasMovies", schema = "cinemaxx")
public class TheaterHallsHasMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_hall_id")
    private int theaterHallId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
}
