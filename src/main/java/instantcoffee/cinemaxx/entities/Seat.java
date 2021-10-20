package instantcoffee.cinemaxx.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @OneToMany(mappedBy = "seat")
    private Set<Booking> bookingSet = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "theater_hall_id", nullable = false)
    TheaterHall theaterHall;
}

