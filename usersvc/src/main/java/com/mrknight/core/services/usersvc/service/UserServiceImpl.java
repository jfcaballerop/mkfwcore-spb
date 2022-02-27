package com.mrknight.core.services.usersvc.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.mrknight.core.services.usersvc.DTOs.UserDTO;
import com.mrknight.core.services.usersvc.model.User;
import com.mrknight.core.services.usersvc.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  UserRepository userRepo;

  public User addUser(UserDTO userDto) throws IOException {

    User user = new User(userDto.getName(), userDto.getLastname(), userDto.getUsername(), userDto.getPassword(),
        userDto.getEmail(), userDto.getActive());
    user = userRepo.insert(user);

    return user;

  }

  public Optional<User> getUser(String id) {
    log.debug("\n*** GetUser ID: {}\n", id);
    Optional<User> user = userRepo.findById(id);
    return user;
  }

  public List<User> getAll() {
    return userRepo.findAll();
  }

}
