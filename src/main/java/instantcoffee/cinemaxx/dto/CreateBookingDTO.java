package instantcoffee.cinemaxx.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateBookingDTO {

    private final String seatId;
    private final String timeSlotId;
    private final String movieId;
    private final String theaterHallId;
}
