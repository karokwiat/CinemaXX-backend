package instantcoffee.cinemaxx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterHallController {
    // NOTE(v3s1e): This is how you get the user inside your request :):w
    /*
    @GetMapping
    public String hello(@AuthenticationPrincipal User user) {
        System.out.println("HELLO");
        System.out.println(user);
        return "hello";
    }*/
}
