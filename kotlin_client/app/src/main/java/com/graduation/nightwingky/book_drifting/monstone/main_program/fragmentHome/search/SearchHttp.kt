package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.search

import com.graduation.nightwingky.book_drifting.monstone.main_program.productList.ProductVO
import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import java.io.IOException
import java.util.ArrayList

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Created by nightwingky on 17-3-19.
 */

object SearchHttp {

    var mList: List<ProductVO> = ArrayList()

    @Throws(IOException::class)
    fun putOut(name: String): String? {
        val okHttpClient = OkHttpClient()

        val formBody = FormBody.Builder()
                .add("name", name)
                .add("keyword", "releaseTime")
                .add("mode", "desc")
                .build()

        val request = Request.Builder()
                .url(URLConst.search_product_list_url)
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
