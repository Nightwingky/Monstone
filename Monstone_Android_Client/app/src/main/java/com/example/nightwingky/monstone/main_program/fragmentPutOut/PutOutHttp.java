package com.example.nightwingky.monstone.main_program.fragmentPutOut;

import com.example.nightwingky.monstone.myConst.URLConst;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 17-3-19.
 */

public class PutOutHttp {

    public static String putOut(String name, String price, String catalog) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("product", name)
                .add("seller", URLConst.getUser_id())
                .add("price", price)
                .add("catalog", catalog)
                .build();

        Request request = new Request.Builder()
                .url(URLConst.getUser_put_out_url())
                .post(formBody)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            return null;
        }
    }
}
