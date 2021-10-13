package instantcoffee.cinemaxx.dto;

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
