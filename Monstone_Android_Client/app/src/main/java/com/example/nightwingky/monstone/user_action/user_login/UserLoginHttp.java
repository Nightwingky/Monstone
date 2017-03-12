package com.example.nightwingky.monstone.user_action.user_login;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 17-3-12.
 */

public class UserLoginHttp {

    public static String userLoginQuery(String URL, String username, String pwd) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("loginName", username)
                .add("password", pwd)
                .build();

        Request request = new Request.Builder()
                .url(URL)
                .post(formBody)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        if(response.isSuccessful()) {
            return response.body().string();
        } else {
            return null;
        }
    }
}
