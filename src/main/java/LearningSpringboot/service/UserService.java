package LearningSpringboot.service;

import LearningSpringboot.entity.User;
import LearningSpringboot.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();
    public UserDto getUserById(int id);
    public UserDto getUserByName(String name);

    public UserDto createUser(User user);

    public UserDto updateUser(int id,User user);

    public boolean deleteUser(int id);

}
