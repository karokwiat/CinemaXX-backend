package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.TheaterHallDTO;

public interface TheaterHallService {
  public TheaterHallDTO getTheaterHallByMovieTimeSlot(int movieId, int timeSlotId);
}