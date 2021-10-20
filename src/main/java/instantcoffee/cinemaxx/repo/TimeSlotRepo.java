package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Integer> {
}
