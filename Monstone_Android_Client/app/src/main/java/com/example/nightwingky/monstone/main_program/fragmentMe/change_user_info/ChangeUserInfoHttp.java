package com.example.nightwingky.monstone.main_program.fragmentMe.change_user_info;

import com.example.nightwingky.monstone.myConst.URLConst;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 17-3-15.
 */

public class ChangeUserInfoHttp {

    private static String query(FormBody formBody, String URL) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

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

    public static String getUserInfo(String URL, String user_id) throws IOException {

        FormBody formBody = new FormBody.Builder()
                .add("no", user_id)
                .build();

        return query(formBody, URL);
    }

    public static String changeUserName(String URL, String name) throws IOException {

        FormBody formBody = new FormBody.Builder()
                .add("no", URLConst.getUser_id())
                .add("name", name)
                .build();

        return query(formBody, URL);
    }

    public static String changeUserGender(String URL, String gender) throws IOException {

        int mGender;

        switch (gender) {
            case "男":
                mGender = 0;
                break;
            case "女":
                mGender = 1;
                break;
            default:
                mGender = 2;
                break;
        }

        FormBody formBody = new FormBody.Builder()
                .add("no", URLConst.getUser_id())
                .add("gender", String.valueOf(mGender))
                .build();

        return query(formBody, URL);
    }

    public static String changeUserMobile(String URL, String mobile) throws IOException {
        FormBody formBody = new FormBody.Builder()
                .add("no", URLConst.getUser_id())
                .add("mobile", mobile)
                .build();

        return query(formBody, URL);
    }
}
