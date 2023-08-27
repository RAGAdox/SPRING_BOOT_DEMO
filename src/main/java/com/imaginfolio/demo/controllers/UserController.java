package com.imaginfolio.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.imaginfolio.demo.models.Users;
import com.imaginfolio.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping
  public Users createUser(@RequestBody Users user) {
    try {
      return userService.createUser(user);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
    }

  }

  @GetMapping
  public List<Users> getAllUsers() {
    try {
      return userService.getAllUsers();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @GetMapping("/{id}")
  public Users getUsers(@PathVariable long id) {
    try {
      return userService.getUserById(id);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @DeleteMapping
  public void deleteAllUsers() {
    try {
      userService.deleteAllUsers();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public void deleteUserById(@PathVariable long id) {
    try {
      userService.deleteUserById(id);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @PatchMapping
  public Users updateUser(@RequestBody Users users) {
    try {
      return userService.updateUser(users);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }
}
