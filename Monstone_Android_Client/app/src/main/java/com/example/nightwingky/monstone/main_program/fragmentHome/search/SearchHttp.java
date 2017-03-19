package com.example.nightwingky.monstone.main_program.fragmentHome.search;

import com.example.nightwingky.monstone.main_program.productList.ProductVO;
import com.example.nightwingky.monstone.myConst.URLConst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 17-3-19.
 */

public class SearchHttp {

    public static List<ProductVO> mList = new ArrayList<>();

    public static String putOut(String name) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("name", name)
                .add("keyword", "releaseTime")
                .add("mode", "desc")
                .build();

        Request request = new Request.Builder()
                .url(URLConst.getSearch_product_list_url())
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
