package com.graduation.nightwingky.book_drifting.monstone.user_action.user_login

import java.io.IOException

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Created by nightwingky on 17-3-12.
 */

object UserLoginHttp {

    @Throws(IOException::class)
    fun userLoginQuery(URL: String, username: String, pwd: String): String? {
        val okHttpClient = OkHttpClient()

        val formBody = FormBody.Builder()
                .add("loginName", username)
                .add("password", pwd)
                .build()

        val request = Request.Builder()
                .url(URL)
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
