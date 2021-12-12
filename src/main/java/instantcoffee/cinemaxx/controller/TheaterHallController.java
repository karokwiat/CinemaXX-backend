package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.TheaterHallDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface TheaterHallController {

  TheaterHallDTO getTheaterHallByMovieTimeSlot(@RequestParam int movieId, @RequestParam int timeSlotId);

}
