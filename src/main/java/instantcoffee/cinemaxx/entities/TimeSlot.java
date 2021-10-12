package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeSlotId;
    @Column(name = "Start_Period", nullable = false)
    private LocalDateTime startingPeriod;
    @Column(name = "End_Period", nullable = false)
    private LocalDateTime endingPeriod;

    @ManyToOne
    Movie movie;
    @ManyToOne
    TheaterHall theaterHall;
}
