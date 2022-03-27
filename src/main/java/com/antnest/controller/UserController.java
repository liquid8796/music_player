package com.antnest.controller;

import com.antnest.dto.UserDTO;
import com.antnest.entity.User;
import com.antnest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody UserDTO user){
        User result = userService.addUser(user);
        return result;
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody UserDTO user){
        User result = userService.updateUser(user);
        return result;
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return "Deleted user - " + id;
    }
}
