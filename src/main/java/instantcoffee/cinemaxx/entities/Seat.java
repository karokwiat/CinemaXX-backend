package instantcoffee.cinemaxx.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "seat_number")
    private String seatNumber;
    @Column(name = "theater_hall_id")
    private int theaterHallId;

}
