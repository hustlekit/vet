package com.vet.controller;

import com.vet.model.dao.UserDao;
import com.vet.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDao> login(@RequestBody Map<String, String> loginMap) {
        UserDao userDao = userService.getUserByLogin(Integer.valueOf(loginMap.get("login")), Integer.valueOf(loginMap.get("pin")));
        return new ResponseEntity<>(userDao, HttpStatus.OK);
    }
}
