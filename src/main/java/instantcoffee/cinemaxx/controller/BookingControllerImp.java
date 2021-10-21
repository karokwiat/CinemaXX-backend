package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.dto.CreateBookingDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.repo.BookingRepo;
import instantcoffee.cinemaxx.service.BookingService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingControllerImp implements BookingController {

    @Autowired
    BookingService bookingService;


    @Override
    public ResponseEntity<BookingDTO> createBooking(@RequestBody CreateBookingDTO createBookingDto,
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
