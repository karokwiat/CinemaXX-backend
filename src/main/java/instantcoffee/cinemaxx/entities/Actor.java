package instantcoffee.cinemaxx.entities;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
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

  @ManyToMany(mappedBy = "actors", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Movie> movies;

}
