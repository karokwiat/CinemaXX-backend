package instantcoffee.cinemaxx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import instantcoffee.cinemaxx.entities.Seat;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeatListDTO {

    private Set<SeatDTO> freeSeats;
    private Set<SeatDTO> bookedSeats;

    public SeatListDTO() {
        this.freeSeats = new HashSet<>();
        this.bookedSeats = new HashSet<>();
    }

    public void addFreeSeat(SeatDTO seat){
        freeSeats.add(seat);
    }

    public void addBookedSeat(SeatDTO seat){
        bookedSeats.add(seat);
    }
}

