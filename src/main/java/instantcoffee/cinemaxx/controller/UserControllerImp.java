package instantcoffee.cinemaxx.controller;

import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.dto.SeatDTO;
import instantcoffee.cinemaxx.dto.TimeSlotDTO;
import instantcoffee.cinemaxx.dto.UserDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.entities.TimeSlot;
import instantcoffee.cinemaxx.service.BookingService;
import instantcoffee.cinemaxx.service.SeatService;
import instantcoffee.cinemaxx.service.TimeSlotService;
import instantcoffee.cinemaxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControllerImp implements UserController {

    UserService userService;
    TimeSlotService timeSlotService;
    SeatService seatService;
    BookingService bookingService;

    @Autowired
    public UserControllerImp(UserService userService, TimeSlotService timeSlotService, SeatService seatService, BookingService bookingService){
        this.userService = userService;
        this.timeSlotService = timeSlotService;
        this.seatService = seatService;
        this.bookingService = bookingService;
    }

    /*@Override
    public BookingDTO createBooking(int userId, int timeSlotId, int seatId) {
        UserDTO userDTO = userService.findById(userId);
        TimeSlotDTO timeSlotDTO = timeSlotService.findById(timeSlotId);
        SeatDTO seatDTO = seatService.findById(seatId);

        BookingDTO bookingDTO = new BookingDTO(userDTO.getUsername(), timeSlotDTO.getScheduledTime(), seatDTO.getSeatNumber());
        bookingService.saveBooking(bookingDTO);
        return bookingDTO;
    }*/

    @Override
    public Booking createBooking(int userId, int timeSlotId, int seatId) {
        UserDTO userDTO = userService.findById(userId);
        TimeSlotDTO timeSlotDTO = timeSlotService.findById(timeSlotId);
        SeatDTO seatDTO = seatService.findById(seatId);

        Booking booking = new Booking(UserDTO.DTOtoEntity(userDTO), TimeSlotDTO.DTOtoEntity(timeSlotDTO), SeatDTO.DTOtoEntity(seatDTO));
        bookingService.saveBooking(booking);
        return booking;
    }
}
