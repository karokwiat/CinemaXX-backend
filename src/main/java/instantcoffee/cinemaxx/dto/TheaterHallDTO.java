package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.TheaterHall;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TheaterHallDTO {

  private int theaterHallId;

  private static ModelMapper modelMapper = new ModelMapper();

  public static TheaterHallDTO entityToDTO(TheaterHall theaterHall) {
    TheaterHallDTO theaterHallDTO = modelMapper.map(theaterHall, TheaterHallDTO.class);
    return theaterHallDTO;
  }

  public static List<TheaterHallDTO> entityToDTO(List<TheaterHall> theaters) {
    return theaters.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
  }

  private static TheaterHall DTOtoEntity(TheaterHallDTO theaterHallDTO) {
    TheaterHall theaterHall = modelMapper.map(theaterHallDTO, TheaterHall.class);
    return theaterHall;
  }

  public static List<TheaterHall> DTOtoEntity(List<TheaterHallDTO> theaterHallDTOS) {
    return theaterHallDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
  }
}