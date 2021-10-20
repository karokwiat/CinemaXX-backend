package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.dto.MovieDTODate;
import instantcoffee.cinemaxx.entities.Movie;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    public void cancelBooking(User user, int id) throws Exception;

}
