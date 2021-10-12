package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TheaterHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterId;

    @OneToMany(mappedBy = "theaterHall")
    List<TimeSlot> timeSlots;
}
