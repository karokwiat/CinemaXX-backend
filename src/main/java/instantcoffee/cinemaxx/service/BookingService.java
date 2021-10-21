package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.dto.SeatListDTO;

import java.time.LocalDateTime;

public interface BookingService {

    public SeatListDTO getSeatListDTO(int theaterHallId, LocalDateTime startTime);

    public void cancel(User user, int id) throws Exception;

    public void edit(User user, BookingDTO bookingDTO) throws Exception;

}
