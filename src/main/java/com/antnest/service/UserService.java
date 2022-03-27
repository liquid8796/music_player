package com.antnest.service;

import com.antnest.dto.UserDTO;
import com.antnest.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User getUserById(long id);

    public User addUser(UserDTO user);

    public User updateUser(UserDTO user);

    public void deleteUser(long id);
}
