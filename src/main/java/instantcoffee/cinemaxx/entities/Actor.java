package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "actors")
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "actor_id")
  private int actorId;
  @Column(name = "firstName")
  private String firstName;
  @Column(name = "lastName")
  private String lastName;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "actorsHasMovies", cascade = CascadeType.REMOVE)
  private Set<Movie> actorsHasMovies;

}
