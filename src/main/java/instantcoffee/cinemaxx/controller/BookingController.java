package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.BookingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.CreateBookingDTO;

public interface BookingController {

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(CreateBookingDTO createBookingDto, User user);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelBooking(@PathVariable int id);

}
