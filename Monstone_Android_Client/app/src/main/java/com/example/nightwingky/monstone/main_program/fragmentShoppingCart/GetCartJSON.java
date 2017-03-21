package com.example.nightwingky.monstone.main_program.fragmentShoppingCart;

import com.example.nightwingky.monstone.myConst.URLConst;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 17-3-21.
 */

public class GetCartJSON {

    public static List<ShoppingCartListVO> getJsonData() throws IOException, JSONException {

        List<ShoppingCartListVO> mList = new ArrayList<>();

        String jsonString = ShoppingCartHttp.getCartContent(URLConst.getUser_id());
        String rightJson = jsonString.replaceAll("\\\\","");//去除转义斜杠
        rightJson = rightJson.replaceAll("\"\\[","[").replaceAll("]\"","]");//去除[]前后的引号
        JSONObject jsonObject = new JSONObject(rightJson);
        jsonObject = jsonObject.getJSONObject("object");
        JSONArray jsonArray = jsonObject.getJSONArray("cartdetail");

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);

            mList.add(new ShoppingCartListVO(
                    jsonObject.getString("no"),
                    jsonObject.getString("sellername"),
                    jsonObject.getString("name"),
                    jsonObject.getString("price"),
                    "来自：北京 海淀 清华东路35号 北京林业大学"
            ));
        }

        return mList;
    }
}
