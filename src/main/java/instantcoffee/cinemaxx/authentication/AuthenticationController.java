package instantcoffee.cinemaxx.authentication;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.security.SignatureException;

@RestController
@RequestMapping("/authenticate")
@AllArgsConstructor
public class AuthenticationController {

    private final JwtUserDetailsService jwtUserDetailsService;

    @PostMapping("/signup")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Signed up successfully", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SignUpResponse.class)) }),
            @ApiResponse(responseCode = "401", description = "Incorrect credentials", content = { @Content }) })
    public ResponseEntity<?> signUp(@RequestBody AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        String email = authenticationRequest.getEmail();

        User user = this.jwtUserDetailsService.signUp(username, password, email);

        if (user == null) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(new SignUpResponse(user.getId(), user.getUsername()));
    }

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Logged in successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LoginResponse.class)) }),
            @ApiResponse(responseCode = "401", description = "Incorrect credentials", content = { @Content }) })
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        String token = this.jwtUserDetailsService.login(username, password);
        System.out.println(token);

        if (token == null) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/check-token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token is valid", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CheckTokenRequest.class)) }),
            @ApiResponse(responseCode = "401", description = "Token is invalid", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CheckTokenResponse.class)) }) })
    public ResponseEntity<?> checkToken(@RequestBody CheckTokenRequest checkTokenRequest) {
        boolean isValid = this.jwtUserDetailsService.checkToken(checkTokenRequest.token);

        if (isValid) {
            return ResponseEntity.ok(new CheckTokenResponse("valid"));
        }

        return ResponseEntity.status(401).body(new CheckTokenResponse("invalid"));
    }
}
