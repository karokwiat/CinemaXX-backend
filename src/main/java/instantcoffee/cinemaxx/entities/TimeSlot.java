package instantcoffee.cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "time_slots")
    private Set<Booking> bookingSet = new HashSet<>();

    /*
     * @ManyToMany
     *
     * @JoinTable( name = "theater_halls_has_movies", joinColumns = @JoinColumn(name
     * = "time_slots_id"), inverseJoinColumns = @JoinColumn(name = "movies") )
     * private Set<Movie> movies;
     */
}
