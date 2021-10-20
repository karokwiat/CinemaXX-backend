package instantcoffee.cinemaxx.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControllerImp implements UserController {

    @Override
    public ResponseEntity<String> createBooking(int userId, int timeSlotId, int seatId) {
        return null;
    }
}
