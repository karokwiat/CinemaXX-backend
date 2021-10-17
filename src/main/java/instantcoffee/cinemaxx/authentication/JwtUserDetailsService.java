package instantcoffee.cinemaxx.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;
  private final JwtTokenUtil jwtTokenUtil;
  private final PasswordEncoder passwordEncoder;

  @Override
  public User loadUserByUsername(String username) {
    User user = this.userRepository.findByUsername(username);
    return user;
  }

  public User signUp(String username, String password) {
    boolean isUsernameTaken = this.userRepository.existsByUsername(username);

    if (isUsernameTaken) {
      return null;
    }

    User user = new User();
    user.setUsername(username);
    user.setPassword(this.passwordEncoder.encode(password));

    return this.userRepository.save(user);
  }

  public String login(String username, String password) {
    User user = this.loadUserByUsername(username);

    if (user == null) {
      return null;
    }

    boolean didPasswordMatch = this.passwordEncoder.matches(password, user.getPassword());

    if (!didPasswordMatch) {
      return null;
    }

    String token = jwtTokenUtil.generateToken(user);

    return token;
  }
}