package instantcoffee.cinemaxx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instantcoffee.cinemaxx.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  public boolean existsByUsername(String username);
}
