package instantcoffee.cinemaxx.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import instantcoffee.cinemaxx.entities.User;
import instantcoffee.cinemaxx.repo.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;

  public User signUp(String username, String password) {
    if (this.userRepository.existsByUsername(username)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Username already exists");
    }

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    return this.userRepository.save(user);
  }

}
