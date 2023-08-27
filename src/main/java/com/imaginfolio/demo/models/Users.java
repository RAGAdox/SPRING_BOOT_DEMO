package com.imaginfolio.demo.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

enum Role {
  ADMIN,
  USER
};

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class Users {
  private @Id @GeneratedValue Long id;
  private String name;
  private Role role;

  public Users() {
  }

  public Users(String name, String role) {
    this.name = name;
    switch (role.toLowerCase()) {
      case "admin":
        this.role = Role.ADMIN;
        break;
      case "user":
      default:
        this.role = Role.USER;
        break;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Users))
      return false;
    if (((Users) (o)).id == this.id)
      return true;
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.role);
  }

  @Override
  public String toString() {
    return "User{id=" + this.id + ", name" + this.name + ", role=" + this.role + "}";
  }

  public long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Role getRole() {
    return this.role;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public void setRole(String role) {
    switch (role.toLowerCase()) {
      case "admin":
        this.role = Role.ADMIN;
        break;
      case "user":
      default:
        this.role = Role.USER;
        break;
    }
  }

}
