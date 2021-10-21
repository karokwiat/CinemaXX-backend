package instantcoffee.cinemaxx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.CreateBookingDTO;
import instantcoffee.cinemaxx.entities.Booking;

public interface BookingController {

    public ResponseEntity<Booking> createBooking(CreateBookingDTO createBookingDto, User user);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelBooking(@PathVariable int id);

}
