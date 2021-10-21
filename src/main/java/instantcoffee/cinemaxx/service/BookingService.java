package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.*;
import instantcoffee.cinemaxx.authentication.User;


public interface BookingService {

    public BookingDTO createBooking(User user, String theaterHallId, String movieId, String timeSlotId, String seatId);

    public void cancelBooking(int id);
}
