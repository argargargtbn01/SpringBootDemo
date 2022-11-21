package LearningSpringboot.controller;

import LearningSpringboot.entity.User;
import LearningSpringboot.exception.NotFoundException;
import LearningSpringboot.model.dto.UserDto;
import LearningSpringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getUserList(){
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto user = userService.getUserById(id);
        if (user == null){
            throw new NotFoundException("user not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping("/search")
    public ResponseEntity<?> getUserByName(@RequestParam String name){
        UserDto user = userService.getUserByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user){
        UserDto newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user){
        UserDto updateUser = userService.updateUser(id,user);
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
    }
}
