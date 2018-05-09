package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentPutOut

import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import java.io.IOException

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Created by nightwingky on 17-3-19.
 */

object PutOutHttp {

    @Throws(IOException::class)
    fun putOut(name: String, price: String, catalog: String): String? {
        val okHttpClient = OkHttpClient()

        val formBody = FormBody.Builder()
                .add("product", name)
                .add("seller", URLConst.user_id)
                .add("price", price)
                .add("catalog", catalog)
                .build()

        val request = Request.Builder()
                .url(URLConst.user_put_out_url)
                .post(formBody)
                .build()

        val response = okHttpClient.newCall(request).execute()

        return if (response.isSuccessful) {
            response.body()!!.string()
        } else {
            null
        }
    }
}
