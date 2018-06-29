package com.shera.controller;

import com.shera.model.User;

public interface LoginController {

    User authentication(String username, String password);
}
