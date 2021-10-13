package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {

    public Movie findById(int id);
}
