package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepo extends JpaRepository<Movie,Integer> {

}
