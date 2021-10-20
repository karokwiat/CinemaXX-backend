package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.entities.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {

    @PostMapping("/{userId}/timeslots/{timeSlotId}/seats/{seatId}")
    ResponseEntity<String> createBooking(@PathVariable int userId, @PathVariable int timeSlotId, @PathVariable int seatId);
}
