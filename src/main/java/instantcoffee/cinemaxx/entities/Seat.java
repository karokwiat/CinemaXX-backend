package instantcoffee.cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theater_hall_id")
    private TheaterHall theaterHall;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id", referencedColumnName = "seat_id")
    private Set<Booking> bookings = new HashSet<>();
}
