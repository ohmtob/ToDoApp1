package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {

    List<ToDoList> findAll();


    ToDoList findByListId(Long id);

    List<ToDoList> findById(UUID id);
}