package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.CreateBookingDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.service.BookingService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingControllerImp implements BookingController {

    BookingService bookingService;

    @PostMapping("/create")
    @Override
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingDTO createBookingDto,
            @AuthenticationPrincipal User user) {

        return ResponseEntity.ok(
                bookingService.createBooking(
                    user,
                    createBookingDto.getTheaterHallId(),
                    createBookingDto.getMovieId(),
                    createBookingDto.getTimeSlotId(),
                    createBookingDto.getSeatId())
                );
    }

    @Override
    public void cancelBooking(int id) {

    }

}
