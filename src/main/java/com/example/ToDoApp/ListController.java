package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping("/list/{listId}")
    public List getList(@PathVariable Long listId) {
        return listService.getToDoList(listId);
    }

    // Get todo list, based on listId
    @GetMapping("/list/{listId}")
    public java.util.List getList(@PathVariable UUID listId) {
        return listService.getAllToDoListForListId(listId);
    }

    // New todo list
    @PostMapping(value = "/new")
    public ResponseEntity<List> newTodoList(@RequestBody List list) {
        return ResponseEntity.ok( ListService.saveToDoList(list));
    }

    // Edit todo list
    @PutMapping("/edit")
    public ResponseEntity<List> editToDoList(@RequestBody List list) {
        return ResponseEntity.ok( ListService.editToDoList(list));
    }

    // Delete todo list
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteToDoList(@PathVariable Long id) {
        return ResponseEntity.ok( ListService.deleteToDoList(id));
    }


}
