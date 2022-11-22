package LearningSpringboot.service;

import LearningSpringboot.entity.User;
import LearningSpringboot.exception.NotFoundException;
import LearningSpringboot.model.dto.UserDto;
import LearningSpringboot.model.mapper.UserMapper;
import LearningSpringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<>();
        List<User> users = userRepo.findAll();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new NotFoundException("not found"));
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto createUser(User user) {
        userRepo.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(long id, User user) {
        User updatedUser = userRepo.findById(id).orElseThrow(() -> new NotFoundException("not found"));
        updatedUser.setId(id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setAvatar(user.getAvatar());
        updatedUser.setPassword(user.getPassword());
        userRepo.save(updatedUser);
        return UserMapper.toUserDto(updatedUser);
    }

    @Override
    public boolean deleteUser(long id) {
        userRepo.deleteById(id);
        return true;
    }
}
