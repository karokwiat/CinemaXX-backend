package instantcoffee.cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import instantcoffee.cinemaxx.authentication.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "time_slots_id", referencedColumnName = "time_slots_id")
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    private Seat seat;

    public Booking(User user, TimeSlot timeSlot, Seat seat) {
        this.user = user;
        this.timeSlot = timeSlot;
        this.seat = seat;
    }

}
