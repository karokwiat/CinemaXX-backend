package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.TheaterHallDTO;
import instantcoffee.cinemaxx.entities.TheaterHall;
import instantcoffee.cinemaxx.repo.TheaterHallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheaterHallServiceImp implements TheaterHallService {

  @Autowired
  TheaterHallRepo theaterHallRepo;

  @Override
  public TheaterHallDTO getTheaterHallByMovieTimeSlot(int movieId, int timeSlotId) {
    Optional<TheaterHall> theaterHall = theaterHallRepo.getTheaterHallByMovieTimeSlot(movieId, timeSlotId);
    return TheaterHallDTO.entityToDTO(theaterHall.orElse(new TheaterHall()));
  }
}