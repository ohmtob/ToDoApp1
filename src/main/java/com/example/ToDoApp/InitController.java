package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private
    PasswordEncoder encoder;
/*    @GetMapping("/init")
    public String init(){
        User user = userRepository.findByUsername("user");
        if (user == null) {
            user = new User();
            user.setUser("user");
            user.setPassword(encoder.encode("123"));
            userRepository.save(user);
        }
        return "ok";

        }
        */

}