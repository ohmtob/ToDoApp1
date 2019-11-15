package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.example.ToDoApp.UserRepository.findAll;

public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String test() {
        return "login";
    }

    @GetMapping("/login")
    public String getLogin(HttpSession session) {
        String checkSession = (String) session.getAttribute( "username" );
        if (checkSession != null) {
            return "list";
        } else {
            return "login";
        }
    }

    @PostMapping("/login")
    public String postLogin(Model model, HttpSession session, @RequestParam String username, @RequestParam String password) {

        List<User> allInlogs = (List<User>) findAll();

        for (int i = 0; i < allInlogs.size(); i++) {
            if (username.equals( allInlogs.get( i ).getUser() ) && (password.equals( allInlogs.get( i ).getPassword() ))) {
                session.setAttribute( "username", username );
            }
        }

        String checkSession = (String) session.getAttribute( "username" );

        if (checkSession != null) {
            List<User> users = (List<User>) findAll();
            model.addAttribute( "users", users );


   /*         List<User> userList = (List<UserHasList>) UserHasListRepository.findAll();

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get( i ).get());

            }
            model.addAttribute( "list", listall );

            List<Item> listItems = (List<ListHasItem>) listhasitemrepoository.findAll();
            for (int i = 0; i < listItems.size(); i++) {
                if (listItems.get( i ).getOrderhasbeensent()) {
                    listItems.remove( listItems.get( i ) );
                    i--;
                }
            }
            model.addAttribute( "item", items );

            List<Procurement> procurement = (List<Procurement>) procurementrepo.findAll();
            for (int i = 0; i < procurement.size(); i++) {
                if (procurement.get( i ).getHasbeenrecived()) {
                    procurement.remove( procurement.get( i ) );
                    i--;
                }
            }
            model.addAttribute( "procurement", procurement );
            List<Procurementhasproduct> procurementhasproduct = (List<Procurementhasproduct>) procurementproductrepo.findAll();
            for (int i = 0; i < procurementhasproduct.size(); i++) {
                if (procurementhasproduct.get( i ).getProducthasbeenrecived()) {
                    procurementhasproduct.remove( procurementhasproduct.get( i ) );
                    i--;
                }
            }
            model.addAttribute( "procurementhasproduct", procurementhasproduct );
            return "/HandleStock";
        } else {
            return "login";*/
        }
    }
}