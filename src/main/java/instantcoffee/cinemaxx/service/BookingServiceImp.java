package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.dto.SeatListDTO;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.entities.Seat;
import instantcoffee.cinemaxx.entities.TimeSlot;
import instantcoffee.cinemaxx.repo.BookingRepo;
import instantcoffee.cinemaxx.repo.SeatRepo;
import instantcoffee.cinemaxx.repo.TimeSlotRepo;
import org.apache.tomcat.jni.Local;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImp implements BookingService{

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    SeatRepo seatRepo;

    @Autowired
    TimeSlotRepo timeSlotRepo;


    @Override
    public SeatListDTO getSeatListDTO(int theaterHallId, LocalDateTime startTime) {
        SeatListDTO seatListDTO = new SeatListDTO();
        List<Seat> seatList = seatRepo.findAllByTheaterHallId(theaterHallId);
        List<TimeSlot> timeSlotList = timeSlotRepo.findAllByScheduledTime(startTime);
        for (Seat seat: seatList) {
            boolean booked = false;
            for (TimeSlot timeSlot: timeSlotList) {
                List<Booking> bookingList = bookingRepo.findAllByTimeSlotsIdAndSeatId(timeSlot.getTimeSlotId(), seat.getSeatId());
                if (!bookingList.isEmpty()) {
                    seatListDTO.addBookedSeat(seat);
                    booked = true;
                    break;
                }
            }
            if (!booked)
                seatListDTO.addFreeSeat(seat);
        }
        return seatListDTO;
    }

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
