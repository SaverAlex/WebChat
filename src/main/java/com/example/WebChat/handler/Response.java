package com.example.WebChat.handler;

import com.example.WebChat.domain.Message;
import com.example.WebChat.domain.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Response {

    public static ArrayList<Message> newMessageArrayList = new ArrayList();

    public static JSONObject generateResponse(ArrayList<Message> messages) {
        JSONObject response = new JSONObject();
        JSONArray resultArray = new JSONArray();
        for (Message message : messages) {
            resultArray.add(entryMessage(message));
        }
        response.put("data", resultArray);
        newMessageArrayList.clear();
        return response;
    }

    private static JSONObject entryMessage(Message message) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", message.getName());
        jsonObject.put("message", message.getMessage());

        return jsonObject;
    }

    public static void updateNewMessageArray(User sender, String message){
        ArrayList<Message> messagesList = newMessageArrayList;
        Message newMessage = new Message();
        newMessage.setName(sender.getUsername());
        newMessage.setMessage(message);
        messagesList.add(newMessage);
        newMessageArrayList = messagesList;

    }
}
