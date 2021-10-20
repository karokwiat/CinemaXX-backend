package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.dto.MovieDTODate;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.error.ResourceNotFoundException;
import instantcoffee.cinemaxx.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImp implements BookingService {

    BookingService bookingService;

    @Override
    public void cancelBooking(int id) {
        System.out.println("cancel booking.");
    }

}
