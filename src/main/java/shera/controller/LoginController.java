package main.java.shera.controller;

import main.java.shera.model.User;

public interface LoginController {

    User authentication(String username, String password);
}
