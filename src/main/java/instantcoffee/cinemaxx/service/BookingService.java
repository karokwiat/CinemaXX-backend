package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.entities.Movie;

public interface BookingService {

    void saveBooking(Booking booking);
}
