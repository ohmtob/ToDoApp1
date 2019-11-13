package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.UUID;


public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long> {


    // Fungerar både med List och Iterable.
    List<ToDoItem> findByName(String name);

    List<ToDoItem> findByDescription(String description);

    List<ToDoItem> findByListId(UUID listId);

    ToDoItem findByItemId(Long id);

}