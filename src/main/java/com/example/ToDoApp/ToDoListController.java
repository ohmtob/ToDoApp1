package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/list/{listId}")
    public ToDoList getList(@PathVariable Long listId) {
        return toDoListService.getToDoList(listId);
    }

    // Get todo list, based on listId
    @GetMapping("/list/{listId}")
    public List<ToDoList> getList(@PathVariable UUID listId) {
        return toDoListService.getAllToDoListForListId(listId);
    }

    // New todo list
    @PostMapping(value = "/new")
    public ResponseEntity<ToDoList> newTodoList(@RequestBody ToDoList list) {
        return ResponseEntity.ok(ToDoListService.saveToDoList(list));
    }

    // Edit todo list
    @PutMapping("/edit")
    public ResponseEntity<ToDoList> editToDoList(@RequestBody ToDoList list) {
        return ResponseEntity.ok(ToDoListService.editToDoList(list));
    }

    // Delete todo list
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteToDoList(@PathVariable Long id) {
        return ResponseEntity.ok(ToDoListService.deleteToDoList(id));
    }


}
