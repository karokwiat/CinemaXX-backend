package instantcoffee.cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "actors")
public class Actor implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "actor_id")
  private int actorId;
  @Column(name = "firstName")
  private String firstName;
  @Column(name = "lastName")
  private String lastName;

  @JsonIgnore
  @ManyToMany(mappedBy = "actorsHasMovies", cascade = CascadeType.REMOVE)
  private Set<Movie> actorsHasMovies = new HashSet<>();

}
