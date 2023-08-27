package com.imaginfolio.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginfolio.demo.models.Users;
import com.imaginfolio.demo.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public Users createUser(Users user) {
    return userRepository.save(user);
  }

  public List<Users> getAllUsers() {
    return userRepository.findAll();
  }

  public Users getUserById(Long id) {
    Optional<Users> users = userRepository.findById(id);
    return users.get();
  }

  public Users updateUser(Users newUser) {
    Optional<Users> user = userRepository.findById(newUser.getId());
    if (user.isPresent()) {
      Users oldUser = user.get();
      oldUser.setName(newUser.getName());
      oldUser.setRole(newUser.getRole());
      return userRepository.save(oldUser);
    }
    return user.get();
  }

  public void deleteAllUsers() {
    userRepository.deleteAll();
  }

  public void deleteUser(Users user) {
    userRepository.deleteById(user.getId());
  }

  public void deleteUserById(Long userId) {
    userRepository.deleteById(userId);
  }

}
