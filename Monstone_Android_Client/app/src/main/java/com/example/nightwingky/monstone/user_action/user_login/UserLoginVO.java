package com.example.nightwingky.monstone.user_action.user_login;

/**
 * Created by nightwingky on 17-3-12.
 */

public class UserLoginVO {

    private String username;
    private String password;

    public UserLoginVO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
