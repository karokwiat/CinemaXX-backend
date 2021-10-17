package instantcoffee.cinemaxx.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import instantcoffee.cinemaxx.authentication.User;

@RestController
@RequestMapping("/theater")
public class TheaterHallController {
  // NOTE(v3s1e): This is how you get the user inside your request :):w
  @GetMapping
  public String hello(@AuthenticationPrincipal User user) {
    System.out.println("HELLO");
    System.out.println(user);
    return "hello";
  }
}