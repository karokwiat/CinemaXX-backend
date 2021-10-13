package instantcoffee.cinemaxx.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import instantcoffee.cinemaxx.dto.AuthenticationDTO;
import instantcoffee.cinemaxx.entities.User;
import instantcoffee.cinemaxx.service.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/authenticate")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public User signUp(@RequestBody AuthenticationDTO authenticationDTO) {
        return this.authenticationService.signUp(authenticationDTO.getUsername(), authenticationDTO.getPassword());
    }
}
