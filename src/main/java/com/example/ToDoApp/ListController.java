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
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ListService listService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHasListRepository userHasListRepository;
    @Autowired
    private UserController userController;
    @Autowired
    private User user;
    @Autowired
    private List list;
    @Autowired
    private List toDoList;
    @Autowired
    private ListController listController;
    @Autowired
    private UserHasList userHasList;
    @Autowired
    private ListHasItemRepository listHasItemRepository;
    @Autowired
    private Item item;

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
        // Get toDoList, based on listId
        @GetMapping("/list/{listId}")
        public com.example.ToDoApp.List getList (@PathVariable User listId){
            return listService.getAllToDoListForListId( listId );
        }

        // New toDoList
        @PostMapping(value = "/newlist")
        public ResponseEntity<List> newList (@RequestBody List toDoList){
            return ResponseEntity.ok( ListService.saveList(toDoList) );
        }

        // Edit toDoList
        @PutMapping("/editlist")
        public ResponseEntity<List> editList (@RequestBody List toDoList){
            return ResponseEntity.ok( ListService.editList( toDoList ) );
        }

        // Delete toDoList
        @DeleteMapping("/deletelist/{id}")
        public ResponseEntity<Boolean> deleteList (@PathVariable Long id){
            return ResponseEntity.ok( ListService.deleteList( id ) );
        }

    @PostMapping("/list")
    public String postLogin(Model model, HttpSession session, @RequestParam String username, @RequestParam String password) {

        List<User> allInLogs = (List<User>) userRepository.findAll();

        for (int i = 0; i < allInLogs.size(); i++) {
            if (username.equals( allInLogs.get( i ).getUser() ) && (password.equals( allInLogs.get( i ).getPassword() ))) {
                session.setAttribute( "username", username );
            }
        }

        String checkSession = (String) session.getAttribute( "username" );

        if (checkSession != null) {
            List<User> users = (List<User>) userRepository.findAll();
            model.addAttribute( "users", users );

            List<UserHasList> userList = (List<UserHasList>) userHasListRepository.findAll();

            for (int i = 0; i < userList.size(); i++) {
                for(int j = 0; j < users.size(); j++){
                    if (userList.get( i ).getUserId().equals(users.get(j))) ;
                }
            }
            model.addAttribute( "list", list );
            return "/list";
        } else {
            return "login";
        }
    }

}
