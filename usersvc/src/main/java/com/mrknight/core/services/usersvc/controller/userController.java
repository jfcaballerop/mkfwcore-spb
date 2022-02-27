package com.mrknight.core.services.usersvc.controller;

import java.io.IOException;
import java.util.List;

import com.mrknight.core.services.usersvc.DTOs.UserDTO;
import com.mrknight.core.services.usersvc.model.User;
import com.mrknight.core.services.usersvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class userController {

  @Autowired
  UserService userService;

  @GetMapping("echo")
  public ResponseEntity<String> echo() {

    return ResponseEntity.ok("Echo Ping OK ");

  }

  @PostMapping
  public ResponseEntity<User> addUser(@RequestBody UserDTO userDto) {
    // @ResponseStatus(HttpStatus.CREATED)

    try {
      User userNew = userService.addUser(userDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
  }

  @GetMapping
  public ResponseEntity<List<User>> getAll() {
    return ResponseEntity.ok(userService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable String id) {
    User user = userService.getUser(id);

    if (user != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.badRequest().body(null);
    }
  }

}
