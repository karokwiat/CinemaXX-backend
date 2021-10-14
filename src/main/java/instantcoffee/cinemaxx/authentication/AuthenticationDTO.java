package instantcoffee.cinemaxx.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationDTO {
  private String username;
  private String password;
}
