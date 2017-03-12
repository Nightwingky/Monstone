package com.example.nightwingky.monstone.user_action.user_login;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nightwingky on 17-3-12.
 */

public class UserLoginJsonConverter {

    public static String convertJsonString(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        String success = jsonObject.getString("success");

        return success;
    }
}
