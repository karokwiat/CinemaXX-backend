package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.entities.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class BookingDTO {

    private int bookingId;
    private String userEmail;
    private LocalDateTime scheduledTime;
    private String seatNumber;

    public BookingDTO(String userEmail, LocalDateTime scheduledTime, String seatNumber){
        this.userEmail = userEmail;
        this.scheduledTime = scheduledTime;
        this.seatNumber = seatNumber;
    }

    public BookingDTO(Booking booking){
        this.bookingId = booking.getBookingId();
        this.userEmail = booking.getUser().getEmail();
        this.scheduledTime = booking.getTimeSlot().getScheduledTime();
        this.seatNumber = booking.getSeat().getSeatNumber();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static BookingDTO entityToDTO(Booking booking) {
        BookingDTO bookingDTO = modelMapper.map(booking, BookingDTO.class);
        return bookingDTO;
    }

    public static Booking DTOtoEntity(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        return booking;
    }

}
