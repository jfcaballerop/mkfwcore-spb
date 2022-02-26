package com.mrknight.core.services.usersvc.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private String username;
  private String password;
  private String name;
  private String lastname;
  private String email;
  private Boolean active;

}
