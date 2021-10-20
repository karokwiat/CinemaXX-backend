package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;
import instantcoffee.cinemaxx.dto.MovieDTODate;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.error.ResourceNotFoundException;
import instantcoffee.cinemaxx.repo.BookingRepo;
import instantcoffee.cinemaxx.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImp implements BookingService{

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public void cancelBooking(User user, int id) throws Exception {
        Booking booking = bookingRepo.getById(id);
        if(booking.getUserId() == user.getId())
            bookingRepo.delete(booking);
        else
            throw new Exception();
    }

}
