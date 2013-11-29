package controllers;

import models.User;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/users/updates", encoders = {UserEncoder.class})
public class UserEndpoint implements Serializable {
    private static final Set<Session> sessions =
            Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(final Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(final Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
    }

    public void onNewUser(User user) {
        for (Session s : sessions) {
            if (s.isOpen())
                try {
                    s.getBasicRemote().sendObject(user);
                } catch (IOException ignored) {
                } catch (EncodeException ignored) {
                }
        }
    }
}
