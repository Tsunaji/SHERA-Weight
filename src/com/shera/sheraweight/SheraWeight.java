package com.shera.sheraweight;

import com.shera.model.User;
import com.shera.controller.LoginControllerImpl;
import java.io.IOException;

public class SheraWeight {

    public static void main(String[] args) throws IOException {
        LoginControllerImpl loginServiceImpl = new LoginControllerImpl();
        User user = loginServiceImpl.authentication("test", "test");
        System.out.println(user.toString());
    }
}
