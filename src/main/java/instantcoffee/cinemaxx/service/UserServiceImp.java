package instantcoffee.cinemaxx.service;

import instantcoffee.cinemaxx.dto.UserDTO;

import instantcoffee.cinemaxx.error.ResourceNotFoundException;
import instantcoffee.cinemaxx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    UserRepo userRepo;

    private String errorMessage(long id){
        return "Not found User with id = " + id;
    }

    @Autowired
    public UserServiceImp(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDTO findById(int userId) {
        return UserDTO.entityToDTO(userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(userId))));
    }
}
