package LearningSpringboot.service;

import LearningSpringboot.entity.User;
import LearningSpringboot.model.dto.UserDto;
import LearningSpringboot.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "1", "1", "1", "1", "1"));
        users.add(new User(2, "2", "2", "2", "2", "2"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        return null;
    }

    @Override
    public UserDto getUserByName(String name) {
        for (User user: users){
            if (user.getName().contains(name)){
                return UserMapper.toUserDto(user);
            }
        }
        return null;
    }

    @Override
    public UserDto createUser(User user) {
        int size = users.size();
        User newUser = new User(size+1, user.getName(),user.getEmail(),user.getPhone(),user.getAvatar(),user.getPassword());
        users.add(newUser);
        UserDto newUserDto = UserMapper.toUserDto(newUser);
        return newUserDto;
    }

    @Override
    public UserDto updateUser(int id, User user) {
        User newUser = new User(id, user.getName(),user.getEmail(),user.getPhone(),user.getAvatar(),user.getPassword());
        users.set(id-1,newUser);
        UserDto updateUserDto = UserMapper.toUserDto(newUser);
        return updateUserDto;
    }

    @Override
    public boolean deleteUser(int id) {
        User deleteUser =users.remove(id-1);
        if (deleteUser != null){
            return true;
        }
        return false;
    }
}
