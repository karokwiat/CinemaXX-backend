package instantcoffee.cinemaxx.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "time_slots")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_slots_id")
    private int timeSlotId;
    @Column(name = "scheduled_time")
    private LocalDateTime scheduledTime;

    @JsonIgnore
    @ManyToMany(mappedBy = "timeSlots", cascade = CascadeType.REMOVE)
    private Set<Movie> movies;

    /*
     * @ManyToMany
     *
     * @JoinTable( name = "theater_halls_has_movies", joinColumns = @JoinColumn(name
     * = "time_slots_id"), inverseJoinColumns = @JoinColumn(name = "movies") )
     * private Set<Movie> movies;
     */
}
