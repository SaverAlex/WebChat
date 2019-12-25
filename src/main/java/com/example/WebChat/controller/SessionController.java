package com.example.WebChat.controller;

import com.example.WebChat.handler.Response;
import com.example.WebChat.repos.MessageRepo;
import com.example.WebChat.repos.UserRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MessageRepo messageRepo;

    @RequestMapping(path="/session", method= RequestMethod.GET)
    @ResponseBody
    public JSONObject doLogin() {
        return new Response().generateResponse(messageRepo);
    }


}
