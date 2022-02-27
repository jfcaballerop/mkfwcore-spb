package com.mrknight.core.services.usersvc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.time.Instant;
import java.util.Optional;

import com.mrknight.core.services.usersvc.model.User;
import com.mrknight.core.services.usersvc.repository.UserRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("Users Service Tests")
public class UserServiceTests {
  Logger log = LoggerFactory.getLogger(UserServiceTests.class);

  @Autowired
  private UserService userSVC;

  @MockBean
  private UserRepository userRepo;

  @Test
  @DisplayName("it Should Return Null User")
  public void itShouldReturnNullUser() {
    String idTest = "123456789";
    doReturn(Optional.empty()).when(userRepo).findById(idTest);
    Optional<User> userRet = userSVC.getUser(idTest);
    assertEquals(false, userRet.isPresent());
  }

  @Test
  @DisplayName("it Should Return Valid User")
  public void itShouldReturnValidUser() {
    String idTest = "123456789";
    User userMock = new User(idTest, "usernameTest", "passwordTest", "nameTest", "lastnameTest", "emailTest", true,
        Instant.now(), Instant.now());
    doReturn(Optional.of(userMock)).when(userRepo).findById(idTest);

    Optional<User> userRet = userSVC.getUser(idTest);

    assertEquals(userRet.get(), userMock);
  }

}
