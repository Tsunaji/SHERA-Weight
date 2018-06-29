package com.shera.sheraweight;

import com.shera.model.User;
import com.shera.service.LoginServiceImpl;
import java.io.IOException;

public class SheraWeight {

    public static void main(String[] args) throws IOException {
        LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
        User user = loginServiceImpl.authentication("test", "test");
        System.out.println(user.toString());
    }
}
