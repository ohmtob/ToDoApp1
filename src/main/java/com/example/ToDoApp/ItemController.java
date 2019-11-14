package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/item/{itemId}")
    public Item getItem(@PathVariable Long itemId) {
        return itemService.getItem(itemId);
    }

/*
    // Get todo list, based on listId
    @GetMapping("/list/{listId}")
    List<Item> getItem(@PathVariable User listId) {
        return itemService.getAllToDoItemsForListId(listId);
    }
*/

    // New todo item
    @PostMapping(value = "/new")
    public ResponseEntity<Item> newTodoItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.saveToDoItem(item));
    }

    // Edit todo item
    @PutMapping("/edit")
    public ResponseEntity<Item> editToDoItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.editToDoItem(item));
    }

    // Delete todo item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteToDoItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.deleteToDoItem(id));
    }

    // Change completed state
    @PutMapping("/state/{id}")
    public ResponseEntity<Item> completedToDoItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.completeToDoItem(id));
    }
}