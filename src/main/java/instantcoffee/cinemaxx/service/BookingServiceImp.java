package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.BookingDTO;
import instantcoffee.cinemaxx.dto.CreateBookingDTO;
import org.springframework.stereotype.Service;

import instantcoffee.cinemaxx.authentication.User;
import instantcoffee.cinemaxx.entities.Booking;
import instantcoffee.cinemaxx.entities.Movie;
import instantcoffee.cinemaxx.entities.Seat;
import instantcoffee.cinemaxx.entities.TheaterHall;
import instantcoffee.cinemaxx.entities.TimeSlot;
import instantcoffee.cinemaxx.error.BadRequestException;
import instantcoffee.cinemaxx.repo.BookingRepo;
import instantcoffee.cinemaxx.repo.MovieRepo;
import instantcoffee.cinemaxx.repo.SeatRepo;
import instantcoffee.cinemaxx.repo.TheaterHallRepo;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImp implements BookingService {

    private final BookingRepo bookingRepository;
    private final MovieRepo movieRepository;
    private final TheaterHallRepo theaterHallRepository;
    private final SeatRepo seatRepository;

    @Override
    public BookingDTO createBooking(User user, String theaterHallId, String movieId, String timeSlotId, String seatId) {
        TheaterHall theaterHall = theaterHallRepository
            .findById(Integer.parseInt(theaterHallId))
            .orElseThrow(() -> new BadRequestException("Perhaps you should try with a `theaterHallId` that exists?!"));
        System.out.println();
        Movie movie = theaterHall
            .getMovies()
            .stream()
            .filter(
                _movie -> _movie.getMovieId() == Integer.parseInt(movieId)
            )
            .findFirst()
            .orElseThrow(() -> new BadRequestException("Perhaps you should try with a `movieId` that exists?!"));

        TimeSlot timeSlot = movie
            .getTimeSlots()
            .stream()
            .filter(
                _timeSlot -> _timeSlot.getTimeSlotId() == Integer.parseInt(timeSlotId)
            )
            .findFirst()
            .orElseThrow(() -> new BadRequestException("Perhaps you should try with a `timeSlotId` that exists?!"));

        boolean isSeatTaken = timeSlot
            .getBookings()
            .stream()
            .map(
                _booking -> _booking.getSeat()).filter(seat -> seat.getSeatId() == Integer.parseInt(seatId)
            )
            .findFirst()
            .isPresent();

        if (isSeatTaken) {
            throw new BadRequestException("You cannot sit with us.");
        }

        Seat seat = theaterHall
            .getSeats()
            .stream()
            .filter(
                _seat -> _seat.getSeatId() == Integer.parseInt(seatId)
            )
            .findFirst()
            .orElseThrow(() -> new BadRequestException("You want to sit outside the Theater Hall or what?"));

        Booking booking = new Booking(user, timeSlot, seat);

        bookingRepository.save(booking);

        return BookingDTO.entityToDTO(booking);
    }

    @Override
    public void cancelBooking(int id) {
        System.out.println("cancel booking.");
    }

}
