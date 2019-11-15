package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ItemController {
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
    @PostMapping("/item")
    public String postLogin(Model model, HttpSession session, @RequestParam String username, @RequestParam String password) {

        List<User> allInLogs = (List<User>) userRepository.findAll();

        for (int i = 0; i < allInLogs.size(); i++) {
            if (username.equals( allInLogs.get( i ).getUser() ) && (password.equals( allInLogs.get( i ).getPassword() ))) {
                session.setAttribute( "username", username );
            }
        }

        String checkSession = (String) session.getAttribute( "username" );

        if (checkSession != null) {
            java.util.List<User> users = (java.util.List<User>) userRepository.findAll();
            model.addAttribute( "users", users );

            List<ListHasItem> listItems = (List<ListHasItem>) listHasItemRepository.findAll();
            List<Item> items = (List<Item>) itemRepository.findAll();
            List<UserHasList> userList = (List<UserHasList>) userHasListRepository.findAll();

            for (int i = 0; i < userList.size(); i++) {
                for (int j = 0; j < listItems.size(); j++) {
                    if (userList.get( i ).getUserId().equals( users.get( j ) )) ;
                    {
                        for (int k = 0; k < items.size(); k++) {
                            if (listItems.get( j ).getItemId().equals( items.get( k ) )) ;
                        }
                    }
                }
            }
            model.addAttribute( "item", item );
            return "/item";
        } else {
            return "login";
        }
    }


}