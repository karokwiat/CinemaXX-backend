package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.MovieDTOCustomer;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public interface MovieService {

    MovieDTOCustomer getById(int id);


    void delete(int id);

}
