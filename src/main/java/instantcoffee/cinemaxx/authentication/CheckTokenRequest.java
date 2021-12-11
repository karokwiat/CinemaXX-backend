package instantcoffee.cinemaxx.authentication;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class CheckTokenRequest {
    private String token;
}
