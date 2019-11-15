package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;
import java.util.List;



public interface ItemRepository extends CrudRepository<Item, Long> {

List<Item> findAll();

    List<Item> findByListId(User listId);

    Item findByItemId(Long id);

}