package instantcoffee.cinemaxx.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import instantcoffee.cinemaxx.entities.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    public List<Movie> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startRange, LocalDate endRange);

/*    @RestResource(
            path = "getAllByRange",
            rel = "getAllByRange")
    @Query("SELECT m FROM Movie m WHERE m.startDate <= :endRange and m.endDate >= :startRange")
    List<Movie> getAllByRange(
            @Param("startRange") LocalDate startRange,
            @Param("endRange") LocalDate endRange);*/
}
