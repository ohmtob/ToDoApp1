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
    // Get todo item, based on itemId
    @GetMapping("/item/{itemId}")
    List<Item> getItem(@PathVariable User itemId) {
        return itemService.getAllToDoItemsForItemId(itemId);
    }
*/

    // New todo item
    @PostMapping(value = "/newitem")
    public ResponseEntity<Item> newItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.saveItem(item));
    }

    // Edit todo item
    @PutMapping("/edititem")
    public ResponseEntity<Item> editItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.editItem(item));
    }

    // Delete todo item
    @DeleteMapping("/deleteitem/{id}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.deleteItem(id));
    }

    // Change completed state
    @PutMapping("/state/{id}")
    public ResponseEntity<Item> completedItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.completedItem(id));
    }
}