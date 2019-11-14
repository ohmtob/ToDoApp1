package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.UUID;


public interface ItemRepository extends CrudRepository<Item, Long> {


    List<Item> findByName(String name);

    List<Item> findByDescription(String description);

    List<Item> findByListId(UUID listId);

    Item findByItemId(Long id);

}