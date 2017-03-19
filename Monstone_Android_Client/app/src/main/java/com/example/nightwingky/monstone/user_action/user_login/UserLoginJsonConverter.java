package com.example.nightwingky.monstone.user_action.user_login;

import android.util.Log;

import com.example.nightwingky.monstone.myConst.URLConst;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nightwingky on 17-3-12.
 */

public class UserLoginJsonConverter {

    public static String convertJsonString(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        String success = jsonObject.getString("success");
        String user_id = jsonObject.getString("object");

        URLConst.setUser_id(user_id);
        Log.d("user_id", URLConst.getUser_id());

        return success;
    }
}
