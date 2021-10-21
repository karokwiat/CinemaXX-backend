package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    List<Booking> findAllByTimeSlotsId(int id);
    List<Booking> findAllByTimeSlotsIdAndSeatId(int timeSlotId, int seatId);
}
