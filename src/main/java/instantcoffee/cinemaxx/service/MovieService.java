package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTO;
import instantcoffee.cinemaxx.dto.MovieDTOCustomer;

import javax.transaction.Transactional;

public interface MovieService {

    MovieDTOCustomer getById(int id);

    void delete(int id);

    @Transactional
    void edit(MovieDTO movie);

}
