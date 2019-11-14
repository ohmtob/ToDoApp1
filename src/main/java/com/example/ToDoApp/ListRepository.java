package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;


public interface ListRepository extends CrudRepository<List, Long> {

    java.util.List findAll();

    List findByListId(Long id);

    java.util.List findById(User id);
}