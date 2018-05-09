package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.change_user_info

import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import java.io.IOException

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Created by nightwingky on 17-3-15.
 */

object ChangeUserInfoHttp {

    @Throws(IOException::class)
    private fun query(formBody: FormBody, URL: String): String? {
        val okHttpClient = OkHttpClient()

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

    @Throws(IOException::class)
    fun getUserInfo(URL: String, user_id: String): String? {

        val formBody = FormBody.Builder()
                .add("no", user_id)
                .build()

        return query(formBody, URL)
    }

    @Throws(IOException::class)
    fun changeUserName(URL: String, name: String): String? {

        val formBody = FormBody.Builder()
                .add("no", URLConst.user_id)
                .add("name", name)
                .build()

        return query(formBody, URL)
    }

    @Throws(IOException::class)
    fun changeUserGender(URL: String, gender: String): String? {

        val mGender: Int

        when (gender) {
            "男" -> mGender = 0
            "女" -> mGender = 1
            else -> mGender = 2
        }

        val formBody = FormBody.Builder()
                .add("no", URLConst.user_id)
                .add("gender", mGender.toString())
                .build()

        return query(formBody, URL)
    }

    @Throws(IOException::class)
    fun changeUserMobile(URL: String, mobile: String): String? {
        val formBody = FormBody.Builder()
                .add("no", URLConst.user_id)
                .add("mobile", mobile)
                .build()

        return query(formBody, URL)
    }
}
