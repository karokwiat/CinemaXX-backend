package instantcoffee.cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
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
  private Set<Movie> theaterHallsHasMovies = new HashSet<>();

  /*@OneToMany(mappedBy = "theater_hall_id")
  @JsonIgnore
  private Set<Seat> seats;
  public Set<Movie> getMovies() {
    return theaterHallsHasMovies;
  }*/

}
