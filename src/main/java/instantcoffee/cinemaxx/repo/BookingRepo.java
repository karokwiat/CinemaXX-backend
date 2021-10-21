package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.dto.SeatDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.entities.Seat;
import instantcoffee.cinemaxx.entities.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    //List<Booking> findAllByTimeSlotsId(int id);
    List<Booking> findAllByTimeSlot(TimeSlot timeSlot);
    //List<Booking> findAllByTimeSlotsIdAndSeatId(int timeSlotId, int seatId);
    List<Booking> findAllByTimeSlotAndAndSeat(TimeSlot timeSlot, Seat seat);

}
