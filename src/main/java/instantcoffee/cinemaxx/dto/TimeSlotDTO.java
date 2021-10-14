package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.TimeSlot;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class TimeSlotDTO {

    private int timeSlotId;
    private LocalDateTime startingPeriod;
    private LocalDateTime endingPeriod;

    public TimeSlotDTO(TimeSlot timeSlot) {
        this.timeSlotId = timeSlot.getTimeSlotId();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static TimeSlotDTO entityToDTO(TimeSlot timeSlot) {
        TimeSlotDTO timeSlotDTO = modelMapper.map(timeSlot, TimeSlotDTO.class);
        return timeSlotDTO;
    }

    public static List<TimeSlotDTO> entityToDTO(List<TimeSlot> timeSlotList) {
        return timeSlotList.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    private static TimeSlot DTOtoEntity(TimeSlotDTO timeSlotDTO) {
        TimeSlot timeSlot = modelMapper.map(timeSlotDTO, TimeSlot.class);
        return timeSlot;
    }

    public static List<TimeSlot> DTOtoEntity(List<TimeSlotDTO> timeSlotDTOList) {
        return timeSlotDTOList.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }
}
