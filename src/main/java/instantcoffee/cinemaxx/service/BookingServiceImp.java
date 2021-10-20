package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImp implements BookingService{

    BookingRepo bookingRepo;

    @Autowired
    public BookingServiceImp (BookingRepo bookingRepo){
        this.bookingRepo = bookingRepo;
    }


    /*@Override
    public void saveBooking(BookingDTO booking) {
        bookingRepo.save(BookingDTO.DTOtoEntity(booking));
    }*/

    @Override
    public void saveBooking(Booking booking) {
        bookingRepo.save(booking);
    }
}
