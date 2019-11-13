package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class ToDoItemController {
    @Autowired
    private ToDoItemService itemService;

    @GetMapping("/item/{itemId}")
    public ToDoItem getItem(@PathVariable Long itemId) {
        return itemService.getItem(itemId);
    }

    // Get todo list, based on listId
    @GetMapping("/list/{listId}")
    public List<ToDoItem> getItem(@PathVariable UUID listId) {
        return itemService.getAllToDoItemsForListId(listId);
    }

    // New todo item
    @PostMapping(value = "/new")
    public ResponseEntity<ToDoItem> newTodoItem(@RequestBody ToDoItem item) {
        return ResponseEntity.ok(itemService.saveToDoItem(item));
    }

    // Edit todo item
    @PutMapping("/edit")
    public ResponseEntity<ToDoItem> editToDoItem(@RequestBody ToDoItem item) {
        return ResponseEntity.ok(itemService.editToDoItem(item));
    }

    // Delete todo item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteToDoItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.deleteToDoItem(id));
    }

    // Change done state
    @PutMapping("/state/{id}")
    public ResponseEntity<ToDoItem> changeDoneState(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.changeDoneStateForToDoItem(id));
    }
}