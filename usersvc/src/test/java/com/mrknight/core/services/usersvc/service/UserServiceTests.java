package com.mrknight.core.services.usersvc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mrknight.core.services.usersvc.model.User;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Users Service Tests")
public class UserServiceTests {
  Logger log = LoggerFactory.getLogger(UserServiceTests.class);

  @Autowired
  private UserService userSVC;

  @Test
  @DisplayName("itShouldReturnUser")
  public void itShouldReturnUser() {
    User userTest = userSVC.getUser("12345678");
    log.debug("\n\n******** " + userTest);
    assertEquals(null, userTest);
  }

}
