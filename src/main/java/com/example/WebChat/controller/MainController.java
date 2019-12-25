package com.example.WebChat.controller;

import com.example.WebChat.domain.Message;
import com.example.WebChat.domain.User;
import com.example.WebChat.handler.Response;
import com.example.WebChat.repos.MessageRepo;
import com.example.WebChat.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MessageRepo messageRepo;


    @GetMapping("/")
    public String greeting(Map<String,Object> model){
        Iterable<User> users = userRepo.findAll();
        model.put("variableName","Список пользователей: ");
        model.put("users",users);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String,Object> model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.put("username",auth.getName());
        model.put("messages",messageRepo.findAll());
        return "main";
    }

    @PostMapping("/main")
    public String message(@RequestParam String message, Map<String,Object> model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = userRepo.findByUsername(auth.getName());
        Message messageEntity = new Message(sender.getUsername(),message,sender.getId());


        messageRepo.save(messageEntity);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("username", sender.getUsername());
        model.put("messages", messages);
        return "redirect:/main";
    }
}
