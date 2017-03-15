package com.example.nightwingky.monstone.myConst;

/**
 * Created by nightwingky on 17-3-12.
 */

public class MyConst {

    private static String user_id = "";

    private static final String user_login_url = "http://118.228.180.248:8080/api/user/login/common";

    private static final String user_change_info = "http://118.228.180.248:8080/api/user/setting/detail";

    public static void setUser_id(String user_id) {
        MyConst.user_id = user_id;
    }

    public static String getUser_change_info() {
        return user_change_info;
    }

    public static String getUser_id() {
        return user_id;
    }

    public static String getUser_login_url() {
        return user_login_url;
    }


}
