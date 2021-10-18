package instantcoffee.cinemaxx.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instantcoffee.cinemaxx.entities.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    public List<Movie> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startRange, LocalDate endRange);
}
