package com.antnest.service;

import com.antnest.dto.UserDTO;
import com.antnest.entity.User;
import com.antnest.handler.AntnestException;
import com.antnest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> result = userRepository.findById(id);

        if(result.isPresent()) return result.get();
        else throw new AntnestException("User not found id - " + id, 404);
    }

    @Override
    public User addUser(UserDTO user) {
        User result = new User(user.getFirstName(), user.getLastName(), user.getAge(), user.isSinger());
        return userRepository.save(result);
    }

    @Override
    public User updateUser(UserDTO user) {
        User result = getUserById(user.getId());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setAge(user.getAge());
        result.setSinger(user.isSinger());
        return userRepository.save(result);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
