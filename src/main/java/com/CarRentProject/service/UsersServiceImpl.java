package com.CarRentProject.service;

import com.CarRentProject.interfaces.UserService;
import com.CarRentProject.models.User;
import com.CarRentProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUsersByName(String name) {
        return userRepository.findByName(name);
    }
}
