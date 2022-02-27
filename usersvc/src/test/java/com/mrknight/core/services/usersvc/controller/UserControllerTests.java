package com.mrknight.core.services.usersvc.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@DisplayName("Users Controller Tests")
@WebMvcTest
public class UserControllerTests {
  Logger log = LoggerFactory.getLogger(UserControllerTests.class);

  @BeforeAll
  static void setup() {
    Logger log = LoggerFactory.getLogger(UserControllerTests.class);
    log.info("@BeforeAll - executes once before all test methods in this class");
  }

  @BeforeEach
  void init() {
    log.info("@BeforeEach - executes before each test method in this class");
  }

  @Test
  void getAll() {
    log.debug("Testing GET ALL");
  }
}
