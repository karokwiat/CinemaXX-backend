package instantcoffee.cinemaxx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import instantcoffee.cinemaxx.entities.Booking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    private int bookingId;
    private int timeSlotsId;
    private int seatId;

    public BookingDTO(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.timeSlotsId = booking.getTimeSlotsId();
        this.seatId = booking.getSeatId();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static BookingDTO entityToDTO(Booking booking) {
        BookingDTO bookingDTO = modelMapper.map(booking, BookingDTO.class);
        return bookingDTO;
    }

    public static List<BookingDTO> entityToDTO(List<Booking> bookings) {
        return bookings.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Booking DTOtoEntity(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        return booking;
    }

    public static List<Booking> DTOtoEntity(List<BookingDTO> bookingDTOS) {
        return bookingDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }
}
