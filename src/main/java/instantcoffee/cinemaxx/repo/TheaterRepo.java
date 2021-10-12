package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.TheaterHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepo extends JpaRepository<TheaterHall, Integer> {
}
