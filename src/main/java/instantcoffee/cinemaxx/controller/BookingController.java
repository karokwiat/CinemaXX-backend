package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.dto.SeatListDTO;
import instantcoffee.cinemaxx.entities.Booking;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

public interface BookingController {

    @GetMapping
    public SeatListDTO getSeatList(@RequestParam int theaterHallId,
                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime);

    @PostMapping
    public ResponseEntity<String> createBooking(@AuthenticationPrincipal User user, @RequestBody Booking booking);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@AuthenticationPrincipal User user, @PathVariable int id);

    @PutMapping
    public ResponseEntity<String> editBooking(@AuthenticationPrincipal User user, @RequestBody BookingDTO bookingDTO);

}
