package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class ListController {

    @Autowired
    private ListService listService;

 /*   @GetMapping("/list/{listId}")
    public List getList(@PathVariable Long listId) {
        return listService.getToDoList(listId);
    }
*/
    // Get todo list, based on listId
    @GetMapping("/list/{listId}")
    public java.util.List getList(@PathVariable User listId) {
        return listService.getAllToDoListForListId(listId);
    }

    // New todo list
    @PostMapping(value = "/newlist")
    public ResponseEntity<List> newList(@RequestBody List list) {
        return ResponseEntity.ok( ListService.saveList(list));
    }

    // Edit todo list
    @PutMapping("/editlist")
    public ResponseEntity<List> editList(@RequestBody List list) {
        return ResponseEntity.ok( ListService.editList(list));
    }

    // Delete todo list
    @DeleteMapping("/deletelist/{id}")
    public ResponseEntity<Boolean> deleteList(@PathVariable Long id) {
        return ResponseEntity.ok( ListService.deleteList(id));
    }


}
