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
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;
    private int timeSlotsId;
    private int seatId;
    private int userId;
    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    Seat seat;
    @ManyToOne
    @JoinColumn(name = "time_slots_id", nullable = false)
    TimeSlot timeSlot;

}
