package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Integer> {
    public List<TimeSlot> findAllByScheduledTime(LocalDateTime scheduledTime);
}
