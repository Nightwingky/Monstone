package com.graduation.nightwingky.book_drifting.monstone.main_program.productItem

import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import java.io.IOException

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Created by nightwingky on 17-3-20.
 */

object ProductHttp {

    @Throws(IOException::class)
    fun addToCart(no: String, cart: String): String? {
        val okHttpClient = OkHttpClient()

        val formBody = FormBody.Builder()
                .add("no", no)
                .add("cart", cart)
                .build()

        val request = Request.Builder()
                .url(URLConst.add_to_shopping_cart)
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
