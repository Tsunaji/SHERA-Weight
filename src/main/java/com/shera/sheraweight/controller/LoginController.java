package main.java.com.shera.sheraweight.controller;

import main.java.com.shera.sheraweight.model.LdapUser;

public interface LoginController {

    LdapUser authentication(String username, String password);
    
}
