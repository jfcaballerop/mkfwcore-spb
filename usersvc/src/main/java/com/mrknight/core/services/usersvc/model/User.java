package com.mrknight.core.services.usersvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document("users")
public class User {

  @Id
  private String id;

  private final String username;
  private final String password;
  private final String name;
  private final String lastname;
  private final String email;
  private final Boolean active;

}
