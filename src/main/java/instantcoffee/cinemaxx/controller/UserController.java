package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.entities.Booking;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public interface UserController {

    @PutMapping("/{userId}/timeslots/{timeSlotId}/seats/{seatId}")
    //BookingDTO createBooking(@PathVariable int userId, @PathVariable int timeSlotId, @PathVariable int seatId);
    Booking createBooking(@PathVariable int userId, @PathVariable int timeSlotId, @PathVariable int seatId);
}
