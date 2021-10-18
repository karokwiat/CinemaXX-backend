package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "time_slots")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_slots_id")
    private int timeSlotId;
    @Column(name = "scheduled_time")
    private LocalDateTime scheduledTime;

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
