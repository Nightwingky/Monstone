package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentShoppingCart

import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.util.ArrayList

/**
 * Created by nightwingky on 17-3-21.
 */

object GetCartJSON {

    //去除转义斜杠
    //去除[]前后的引号
    val jsonData: List<ShoppingCartListVO>
        @Throws(IOException::class, JSONException::class)
        get() {

            val mList = ArrayList<ShoppingCartListVO>()

            val jsonString = ShoppingCartHttp.getCartContent(URLConst.user_id)
            var rightJson = jsonString!!.replace("\\\\".toRegex(), "")
            rightJson = rightJson.replace("\"\\[".toRegex(), "[").replace("]\"".toRegex(), "]")
            var jsonObject = JSONObject(rightJson)
            jsonObject = jsonObject.getJSONObject("object")
            val jsonArray = jsonObject.getJSONArray("cartdetail")

            for (i in 0 until jsonArray.length()) {
                jsonObject = jsonArray.getJSONObject(i)

                mList.add(ShoppingCartListVO(
                        jsonObject.getString("no"),
                        jsonObject.getString("sellername"),
                        jsonObject.getString("name"),
                        jsonObject.getString("price"),
                        "来自：北京 海淀 清华东路35号 北京林业大学"
                ))
            }

            return mList
        }
}
