package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImp implements BookingService{

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public void cancel(User user, int id) throws Exception {
        Booking booking = bookingRepo.getById(id);
        if(booking.getUserId() == user.getId())
            bookingRepo.delete(booking);
        else
            throw new Exception();
    }

    @Override
    public void edit(User user, BookingDTO bookingDTO) throws Exception {
        Booking booking = BookingDTO.DTOtoEntity(bookingDTO);
        booking.setUserId(user.getId().intValue());
        Booking bookingCompare = bookingRepo.getById(booking.getBookingId());
        if(bookingCompare.getUserId() == user.getId())
            bookingRepo.save(booking);
        else
            throw new Exception();
    }

}
