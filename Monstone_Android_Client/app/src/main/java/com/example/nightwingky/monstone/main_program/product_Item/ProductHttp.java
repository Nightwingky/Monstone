package com.example.nightwingky.monstone.main_program.product_Item;

import com.example.nightwingky.monstone.myConst.URLConst;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 17-3-20.
 */

public class ProductHttp {

    public static String addToCart(String no, String cart) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("no", no)
                .build();

        Request request = new Request.Builder()
                .url(URLConst.getAdd_to_shopping_cart())
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
