package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.BookingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.CreateBookingDTO;
import instantcoffee.cinemaxx.entities.Booking;

import java.util.List;

public interface BookingController {


    @GetMapping
    public List<Booking> getBookings();

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(CreateBookingDTO createBookingDto, User user);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelBooking(@PathVariable int id);

}
