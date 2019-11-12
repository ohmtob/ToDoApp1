package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {

    List<ToDoList> findAll();


}