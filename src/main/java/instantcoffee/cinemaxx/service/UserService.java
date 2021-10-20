package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.UserDTO;

public interface UserService {
    UserDTO findById(int userId);
}
