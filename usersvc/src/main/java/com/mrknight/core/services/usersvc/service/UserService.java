package com.mrknight.core.services.usersvc.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.mrknight.core.services.usersvc.DTOs.UserDTO;
import com.mrknight.core.services.usersvc.model.User;

public interface UserService {
  public User addUser(UserDTO userDto) throws IOException;

  public Optional<User> getUser(String id);

  public List<User> getAll();

}
