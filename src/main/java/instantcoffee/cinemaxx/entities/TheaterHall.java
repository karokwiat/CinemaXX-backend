package instantcoffee.cinemaxx.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "theater_halls")
public class TheaterHall {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "theater_hall_id")
  private int theaterHallId;

  //@OneToMany(mappedBy = "")
  //List<TimeSlot> timeSlots;
}