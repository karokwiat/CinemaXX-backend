package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "time_slots", schema = "cinemaxx")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_slots_id")
    private int timeSlotId;
    @Column(name = "scheduled_time")
    private LocalDateTime scheduled_time;

    @ManyToMany(mappedBy = "timeSlots")
    private Set<Movie> movies = new HashSet<>();


/*    @OneToMany(mappedBy= "time_slots")
    private List<TheaterHallsHasMovies> theaterHallsHasMovies;*/


 //   @ManyToOne
 //   Movie movie;
    @ManyToOne
    TheaterHall theaterHall;
}
