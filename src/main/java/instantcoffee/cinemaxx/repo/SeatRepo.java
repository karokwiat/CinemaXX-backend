package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
    public List<Seat> findAllByTheaterHallId(int id);
}
