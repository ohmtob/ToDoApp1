package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;


public interface ListRepository extends CrudRepository<List, Long> {

    Iterable<List> findAll();

    List findByListId(Long id);

    List findById(User id);
}