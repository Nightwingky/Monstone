package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentShoppingCart

import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import java.io.IOException

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Created by nightwingky on 17-3-21.
 */

object ShoppingCartHttp {

    @Throws(IOException::class)
    fun getCartContent(id: String): String? {
        val okHttpClient = OkHttpClient()

        val formBody = FormBody.Builder()
                .add("no", id)
                .build()

        val request = Request.Builder()
                .url(URLConst.get_content_from_shopping_cart_url)
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
