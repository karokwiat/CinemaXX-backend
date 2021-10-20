package instantcoffee.cinemaxx.repo;

import instantcoffee.cinemaxx.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
