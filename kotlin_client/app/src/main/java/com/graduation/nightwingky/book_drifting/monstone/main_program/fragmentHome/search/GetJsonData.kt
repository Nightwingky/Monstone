package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.search

import android.util.Log

import com.graduation.nightwingky.book_drifting.monstone.main_program.productList.ProductVO

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.util.ArrayList

/**
 * Created by nightwingky on 17-3-19.
 */

object GetJsonData {

    @Throws(IOException::class, JSONException::class)
    fun getJsonData(queryText: String): List<ProductVO> {
        val mList = ArrayList<ProductVO>()
        var productVO: ProductVO

        val jsonString = SearchHttp.putOut(queryText)
        var rightJson = jsonString!!.replace("\\\\".toRegex(), "")//去除转义斜杠
        rightJson = rightJson.replace("\"\\[".toRegex(), "[").replace("]\"".toRegex(), "]")//去除[]前后的引号
        var jsonObject = JSONObject(rightJson)
        val jsonArray = jsonObject.getJSONArray("object")

        for (i in 0 until jsonArray.length()) {
            jsonObject = jsonArray.getJSONObject(i)
            productVO = ProductVO()
            productVO.name = jsonObject.getString("name")
            productVO.seller = jsonObject.getString("sellername")
            productVO.price = jsonObject.getString("price")
            productVO.catalog = jsonObject.getString("catalog")
            productVO.releaseTime = jsonObject.getString("releasetime")
            productVO.productId = jsonObject.getString("no")

            mList.add(productVO)
        }

        Log.d("searchList", mList.toString())
        return mList
    }
}
