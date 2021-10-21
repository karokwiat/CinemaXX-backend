package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.Actor;
import instantcoffee.cinemaxx.entities.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CreateBookingDTO {

    private final String seatId;
    private final String timeSlotId;
    private final String movieId;
    private final String theaterHallId;

    public CreateBookingDTO(String seatId, String timeSlotId, String movieId, String theaterHallId) {
        this.seatId = seatId;
        this.timeSlotId = timeSlotId;
        this.movieId = movieId;
        this.theaterHallId = theaterHallId;
    }
}
