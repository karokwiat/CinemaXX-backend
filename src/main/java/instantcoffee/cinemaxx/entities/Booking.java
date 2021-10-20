package instantcoffee.cinemaxx.entities;

import instantcoffee.cinemaxx.authentication.User;
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
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}

