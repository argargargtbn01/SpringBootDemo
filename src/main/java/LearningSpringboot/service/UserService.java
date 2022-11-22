package LearningSpringboot.service;

import LearningSpringboot.entity.User;
import LearningSpringboot.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     List<UserDto> getListUser();
     UserDto getUserById(long id);

     UserDto createUser(User user);

     UserDto updateUser(long id,User user);

     boolean deleteUser(long id);

}
