package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
}
