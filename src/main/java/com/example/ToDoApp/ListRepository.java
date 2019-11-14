package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ListRepository extends CrudRepository<List, Long> {

    java.util.List findAll();

    List findByListId(Long id);

    java.util.List findById(UUID id);
}