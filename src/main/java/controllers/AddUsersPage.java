package controllers;

import models.User;
import services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class AddUsersPage {
    @Inject
    private UserService userService;
    @Inject
    private UserEndpoint userEndpoint;

    @NotNull
    @Size(min = 3, max = 40)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String submit() {
        User user = new User();
        user.setEmail(email);
        userService.addUser(user);
        userEndpoint.onNewUser(user);
        email = null;
        return "success";
    }
}
