package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;
    @Autowired
    private UserRepository userRepository;

/*    @GetMapping("/login")
    public String getLogin(HttpSession session) {
        String checkSession = (String)session.getAttribute("username");
        if (checkSession != null) {
            return "list";
        } else {
            return "login";
        }
    }*/



    @GetMapping("/list/{listId}")
    public com.example.ToDoApp.List getList(@PathVariable Long listId) {
        return listService.getList(listId);
    }
        // Get todo list, based on listId
        @GetMapping("/list/{listId}")
        public com.example.ToDoApp.List getList (@PathVariable User listId){
            return listService.getAllToDoListForListId( listId );
        }

        // New todo list
        @PostMapping(value = "/newlist")
        public ResponseEntity<List> newList (@RequestBody List list){
            return ResponseEntity.ok( ListService.saveList( list ) );
        }

        // Edit todo list
        @PutMapping("/editlist")
        public ResponseEntity<List> editList (@RequestBody List list){
            return ResponseEntity.ok( ListService.editList( list ) );
        }

        // Delete todo list
        @DeleteMapping("/deletelist/{id}")
        public ResponseEntity<Boolean> deleteList (@PathVariable Long id){
            return ResponseEntity.ok( ListService.deleteList( id ) );
        }

    @PostMapping("/login")
    public String postLogin(Model model, HttpSession session, @RequestParam String username, @RequestParam String password) {

        List<User> allInLogs = (List<User>) UserRepository.findAll();

        for (int i = 0; i < allInLogs.size(); i++) {
            if (username.equals( allInLogs.get( i ).getUser() ) && (password.equals( allInLogs.get( i ).getPassword() ))) {
                session.setAttribute( "username", username );
            }
        }

        String checkSession = (String) session.getAttribute( "username" );

        if (checkSession != null) {
            java.util.List<User> users = (java.util.List<User>) UserRepository.findAll();
            model.addAttribute( "users", users );

            List<User> userList = (List<UserHasList>) UserHasListRepository.findAll();

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get( i ).get()) ;

            }
            model.addAttribute( "list", listall );
            return "/list";
        } else {
            return "login";
        }
    }

}
