package com.example.nightwingky.monstone.main_program.me.change_user_info;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 17-3-15.
 */

public class ChangeUserInfoHttp {

    public static String changeUserInfoQuery(String URL, String user_id) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("no", user_id)
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
