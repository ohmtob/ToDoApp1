package com.example.ToDoApp;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { // JpaRepository???
    org.springframework.security.core.userdetails.User findByUsername(String username);
}