package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.dto.SeatListDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/bookings")
public class BookingControllerImp implements BookingController {

    @Autowired
    BookingService bookingService;

    @Override
    public SeatListDTO getSeatList(int theaterHallId, LocalDateTime startTime) {
        return bookingService.getSeatListDTO(theaterHallId, startTime);
    }

    @Override
    public ResponseEntity<String> createBooking(User user, Booking booking) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<String> editBooking(User user, BookingDTO bookingDTO) {
        try {
            bookingService.edit(user, bookingDTO);
            return ResponseEntity.ok("{message: \"Booking successfully updated\"}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{message: \"Failed to update booking\"}");
        }
    }

    @Override
    public ResponseEntity<String> cancelBooking(User user, int id) {
        try {
            bookingService.cancel(user, id);
            return ResponseEntity.ok("{message : \"Booking canceled\"}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{message : \"Failed to cancel booking\"}");
        }
    }

}
