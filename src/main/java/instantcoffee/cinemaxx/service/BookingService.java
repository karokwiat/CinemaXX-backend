package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.dto.BookingDTO;

public interface BookingService {

    public void cancel(User user, int id) throws Exception;

    public void edit(User user, BookingDTO bookingDTO) throws Exception;

}
