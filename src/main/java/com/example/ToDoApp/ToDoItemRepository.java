package com.example.ToDoApp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long> {


    // Fungerar både med List och Iterable.
    List<ToDoItem> findByName(String name);

    List<ToDoItem> findByDescription(String description);
/*
    @Query("SELECT d FROM Dog d WHERE d.age = ?1")
    Iterable<Dog> findDogsWithQueryAge(int age);
*/
}