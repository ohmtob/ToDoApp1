package com.example.ToDoApp;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    org.springframework.security.core.userdetails.User findByUsername(String username);
}