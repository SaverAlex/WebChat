package com.example.WebChat.handler;

import com.example.WebChat.domain.Message;
import com.example.WebChat.repos.MessageRepo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Response {

    public JSONObject generateResponse(MessageRepo messageRepo) {
        JSONObject response = new JSONObject();
        Iterable<Message> messageIterator = messageRepo.findAll();

        response.put("data", generateMessagesArray(messageIterator));

        return response;
    }
    private JSONArray generateMessagesArray(Iterable<Message> messageIterator) {
        JSONArray resultArray = new JSONArray();
        for (Message message : messageIterator) {
            resultArray.add(entryMessage(message));
        }

        return resultArray;
    }
    private JSONObject entryMessage(Message message) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", message.getName());
        jsonObject.put("message", message.getMessage());

        return jsonObject;
    }
}
