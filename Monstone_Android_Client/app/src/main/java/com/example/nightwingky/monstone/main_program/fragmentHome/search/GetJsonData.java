package com.example.nightwingky.monstone.main_program.fragmentHome.search;

import android.util.Log;

import com.example.nightwingky.monstone.main_program.productList.ProductVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 17-3-19.
 */

public class GetJsonData {

    public static List<ProductVO> getJsonData(String queryText) throws IOException, JSONException {
        List<ProductVO> mList = new ArrayList<>();
        ProductVO productVO;

        String jsonString = SearchHttp.putOut(queryText);
        String rightJson = jsonString.replaceAll("\\\\","");//去除转义斜杠
        rightJson = rightJson.replaceAll("\"\\[","[").replaceAll("]\"","]");//去除[]前后的引号
        JSONObject jsonObject = new JSONObject(rightJson);
        JSONArray jsonArray = jsonObject.getJSONArray("object");

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            productVO = new ProductVO();
            productVO.setName(jsonObject.getString("name"));
            productVO.setSeller(jsonObject.getString("sellername"));
            productVO.setPrice(jsonObject.getString("price"));
            productVO.setCatalog(jsonObject.getString("catalog"));
            productVO.setReleaseTime(jsonObject.getString("releasetime"));
            productVO.setProductId(jsonObject.getString("no"));

            mList.add(productVO);
        }

        Log.d("searchList", String.valueOf(mList));
        return mList;
    }
}
