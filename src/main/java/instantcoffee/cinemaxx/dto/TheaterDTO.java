package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.TheaterHall;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Getter
public class TheaterDTO {

    private int theaterId;

    public TheaterDTO(TheaterHall theaterHall) {
        this.theaterId = theaterHall.getTheaterId();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static TheaterDTO entityToDTO(TheaterHall theaterHall) {
        TheaterDTO theaterDTO = modelMapper.map(theaterHall, TheaterDTO.class);
        return theaterDTO;
    }

    public static List<TheaterDTO> entityToDTO(List<TheaterHall> theaters) {
        return theaters.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    private static TheaterHall DTOtoEntity(TheaterDTO theaterDTO) {
        TheaterHall theaterHall = modelMapper.map(theaterDTO, TheaterHall.class);
        return theaterHall;
    }

    public static List<TheaterHall> DTOtoEntity(List<TheaterDTO> theaterDTOS) {
        return theaterDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }
}
