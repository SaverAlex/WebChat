package com.example.WebChat.controller;

import com.example.WebChat.repos.MessageRepo;
import com.example.WebChat.repos.UserRepo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class SessionController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MessageRepo messageRepo;

    @RequestMapping(path="/session", method= RequestMethod.GET)
    @ResponseBody
    public JSONObject doLogin() {
        JSONObject response = new JSONObject();
        System.out.println(1212);
        JSONArray array = new JSONArray();
        JSONObject n = new JSONObject();
        n.put("username", "Alex");
        n.put("message", "Hello");
        array.add(n);

        response.put("data", array);
        return response;
    }
}
