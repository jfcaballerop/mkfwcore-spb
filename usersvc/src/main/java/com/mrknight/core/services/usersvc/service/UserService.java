package com.mrknight.core.services.usersvc.service;

import java.io.IOException;

import com.mrknight.core.services.usersvc.DTOs.UserDTO;
import com.mrknight.core.services.usersvc.model.User;
import com.mrknight.core.services.usersvc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepo;

  public User addUser(UserDTO userDto) throws IOException {

    User user = new User(userDto.getName(), userDto.getLastname(), userDto.getUsername(), userDto.getPassword(),
        userDto.getEmail(), userDto.getActive());
    user = userRepo.insert(user);

    return user;

  }

  public User getUser(String id) {
    return userRepo.findById(id).get();
  }

}
