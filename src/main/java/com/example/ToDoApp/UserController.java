package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

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

        List<User> allInlogs = (List<User>) userRepository.findAll();

        for (int i = 0; i < allInlogs.size(); i++) {
            if (username.equals( allInlogs.get( i ).getUser() ) && (password.equals( allInlogs.get( i ).getPassword() ))) {
                session.setAttribute( "username", username );
            }
        }

        String checkSession = (String) session.getAttribute( "username" );

        if (checkSession != null) {
            List<User> users = (List<User>) userRepository.findAll();
            model.addAttribute( "users", users );


            return "/list";
        } else {
            return "login";
        }
    }
}