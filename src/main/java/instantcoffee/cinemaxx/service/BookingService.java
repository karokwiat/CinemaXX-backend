package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.dto.MovieDTODate;
import instantcoffee.cinemaxx.entities.Movie;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    public Booking createBooking(String theaterHallId, String movieId, String timeSlotId, seatId);

    public void cancelBooking(int id);
}
