package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.entities.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;


@NoArgsConstructor
@Getter
@Setter
public class SeatDTO {
    private String seatNumber;
    private static ModelMapper modelMapper = new ModelMapper();

    public static SeatDTO entityToDTO(Seat seat) {
        SeatDTO seatDTO = modelMapper.map(seat, SeatDTO.class);
        return seatDTO;
    }

    public static Seat DTOtoEntity(SeatDTO seatDTO) {
        Seat seat = modelMapper.map(seatDTO, Seat.class);
        return seat;
    }
}
