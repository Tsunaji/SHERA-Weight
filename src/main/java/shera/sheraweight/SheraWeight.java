package main.java.shera.sheraweight;

import java.io.IOException;
import main.java.shera.controller.LoginControllerImpl;
import main.java.shera.model.User;

public class SheraWeight {

    public static void main(String[] args) throws IOException {
        LoginControllerImpl loginServiceImpl = new LoginControllerImpl();
        User user = loginServiceImpl.authentication("jirasak_ka", "Tsunaji230425352");
//        System.out.println(user.toString());
        if (user == null) {
            System.out.println("FAIL!");
        } else {
            System.out.println("SUCCESS!");
        }
    }
}
