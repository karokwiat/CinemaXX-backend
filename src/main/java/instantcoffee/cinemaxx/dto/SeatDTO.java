package instantcoffee.cinemaxx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import instantcoffee.cinemaxx.entities.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeatDTO {

    private int seatId;
    private String seatNumber;

    public SeatDTO(Seat seat) {
        this.seatId = seat.getSeatId();
        this.seatNumber = seat.getSeatNumber();
    }
    private static ModelMapper modelMapper = new ModelMapper();

    public static SeatDTO entityToDTO(Seat seat) {
        SeatDTO seatDTO = modelMapper.map(seat, SeatDTO.class);
        return seatDTO;
    }
    public static List<SeatDTO> entityToDTO(List<Seat> seats) {
        return seats.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }
    public static Seat DTOtoEntity(SeatDTO seatDTO) {
        Seat seat = modelMapper.map(seatDTO, Seat.class);
        return seat;
    }
    public static List<Seat> DTOtoEntity(List<SeatDTO> seatDTOS) {
        return seatDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }
}
