package com.graduation.nightwingky.book_drifting.monstone.user_action.user_login

import android.util.Log

import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import org.json.JSONException
import org.json.JSONObject

/**
 * Created by nightwingky on 17-3-12.
 */

object UserLoginJsonConverter {

    @Throws(JSONException::class)
    fun convertJsonString(jsonString: String): String {
        val jsonObject = JSONObject(jsonString)

        val success = jsonObject.getString("success")
        val user_id = jsonObject.getString("object")

        URLConst.user_id = user_id
        Log.d("user_id", URLConst.user_id)

        return success
    }
}
