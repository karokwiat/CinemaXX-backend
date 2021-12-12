package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.TheaterHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterHallRepo extends JpaRepository<TheaterHall, Integer> {

  @Query(value="SELECT t.* FROM theater_halls t INNER JOIN theater_halls_has_movies thm ON t.theater_hall_id=thm.theater_hall_id WHERE thm.movie_id = :movieId AND thm.time_slot_id = :timeSlotId",
      nativeQuery = true)
  Optional<TheaterHall> getTheaterHallByMovieTimeSlot(
      @Param("movieId") int movieId,
      @Param("timeSlotId") int timeSlotId);

}