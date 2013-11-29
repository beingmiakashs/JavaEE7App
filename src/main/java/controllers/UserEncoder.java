package controllers;

import models.User;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class UserEncoder implements Encoder.Text<User> {
    private String someField;

    @Override
    public String encode(User user) throws EncodeException {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("email", user.getEmail()).build();
        return jsonObject.toString();
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }
}
