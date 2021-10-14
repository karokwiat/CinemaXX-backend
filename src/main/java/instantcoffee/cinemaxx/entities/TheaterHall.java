package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "theater_halls")
public class TheaterHall {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "theater_hall_id")
  private int theaterHallId;
  @Column(name = "movie_theater_id")
  private int movieTheaterId;

  @ManyToMany
  @JoinTable(
      name = "theater_halls_has_movies",
      joinColumns = @JoinColumn(name = "theater_hall_id"),
      inverseJoinColumns = @JoinColumn(name = "movie_id"))
  private Set<Movie> theaterHallsHasMovies;

}