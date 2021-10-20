package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
}
