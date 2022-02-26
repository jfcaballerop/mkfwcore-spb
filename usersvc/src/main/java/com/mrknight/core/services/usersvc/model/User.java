package com.mrknight.core.services.usersvc.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Document("users")
public class User {

  @Id
  private String id;

  @NonNull
  private String username;
  @NonNull
  private String password;
  @NonNull
  private String name;
  @NonNull
  private String lastname;
  @NonNull
  private String email;
  @NonNull
  private Boolean active;

  @CreatedDate
  private Instant createdDate;

  @LastModifiedDate
  private Instant lastModifiedDate;

}
