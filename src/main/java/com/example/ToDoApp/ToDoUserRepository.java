package com.example.ToDoApp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoUserRepository extends CrudRepository<ToDoUser, Long> {

    // Fungerar både mec List och Iterable.
    List<ToDoUser> findByName(String name);


}
