package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingControllerImp implements BookingController {

    BookingService bookingService;

    @Override
    public ResponseEntity<String> createBooking(User user, Booking booking) {
        return null;
    }

    @Override
    public void cancelBooking(int id) {

    }

}
