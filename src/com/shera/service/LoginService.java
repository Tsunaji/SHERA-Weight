package com.shera.service;

import com.shera.model.User;

public interface LoginService {

    User authentication(String username, String password);
}
