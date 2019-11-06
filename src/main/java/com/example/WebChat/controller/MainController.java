package com.example.WebChat.controller;

import com.example.WebChat.domain.User;
import com.example.WebChat.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String,Object> model){
//        UserTag userTag = new UserTag("Jack","9876");
//        userRepo.save(userTag);
//        UserTag userTag2 = new UserTag("Alex","197");
//        userRepo.save(userTag2);
        Iterable<User> users = userRepo.findAll();
        model.put("variableName","Список пользователей: ");
        model.put("users",users);
        //userRepo.deleteAll();
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String,Object> model){
        Iterable<User> users = userRepo.findAll();
        model.put("users",users);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String login, @RequestParam String password, Map<String,Object> model){
        User user = new User(login,password);
        userRepo.save(user);
        Iterable<User> users = userRepo.findAll();
        model.put("users",users);
        return "main";
    }
}
