package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.TheaterHallDTO;
import instantcoffee.cinemaxx.service.TheaterHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterHallControllerImp {
  // NOTE(v3s1e): This is how you get the user inside your request :):w
    /*
    @GetMapping
    public String hello(@AuthenticationPrincipal User user) {
        System.out.println("HELLO");
        System.out.println(user);
        return "hello";
    }*/


  @Autowired
  TheaterHallService theaterHallService;

  @GetMapping
  TheaterHallDTO getTheaterHallByMovieTimeSlot(@RequestParam int movieId, @RequestParam int timeSlotId) {
    return theaterHallService.getTheaterHallByMovieTimeSlot(movieId, timeSlotId);
  }

}
