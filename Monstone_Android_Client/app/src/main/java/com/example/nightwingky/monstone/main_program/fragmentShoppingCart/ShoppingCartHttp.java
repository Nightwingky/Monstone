package com.example.nightwingky.monstone.main_program.fragmentShoppingCart;

import com.example.nightwingky.monstone.myConst.URLConst;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 17-3-21.
 */

public class ShoppingCartHttp {

    public static String getCartContent(String id) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("no", id)
                .build();

        Request request = new Request.Builder()
                .url(URLConst.getGet_content_from_shopping_cart_url())
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
