package com.example.nightwingky.monstone.main_program.me.change_user_info;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.myConst.MyConst;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChangeUserInfoActivity extends AppCompatActivity {

    private String info_url = MyConst.getUser_change_info_url();
    private String name_url = MyConst.getUser_change_name_url();
    private String gender_url = MyConst.getUser_change_gender_url();
    private String mobile_url = MyConst.getUser_change_mobile_url();

    private ListView mListView;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_info);

        bindView();

        new GetUserInfoAsync().execute(info_url);
    }

    private void bindView() {
        this.mListView = (ListView) findViewById(R.id.lv_change_user_info);
        this.btn_save = (Button) findViewById(R.id.btn_save_change_user_info);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private ChangeUserInfoVO getVOByJsonData() throws IOException, JSONException {
        String jsonString = ChangeUserInfoHttp.getUserInfo(info_url, MyConst.getUser_id());

        JSONObject jsonObject = new JSONObject(jsonString);
        jsonObject = new JSONObject(jsonObject.getString("object"));

        ChangeUserInfoVO changeUserInfoVO = new ChangeUserInfoVO(
                MyConst.getUser_id(),
                jsonObject.getString("name"),
                jsonObject.getInt("gender"),
                jsonObject.getString("birth"),
                jsonObject.getString("mobile"),
                jsonObject.getString("email"),
                jsonObject.getString("portrait"),
                jsonObject.getString("introduction")
        );

        return changeUserInfoVO;
    }

    private boolean getSuccessByJsonData(String name, String gender, String mobile) throws IOException, JSONException {
        List<String> mList = new ArrayList<String>();
        String jsonString;
        JSONObject jsonObject;
        boolean flag = true;

        jsonString = ChangeUserInfoHttp.changeUserName(name_url, name);
        jsonObject = new JSONObject(jsonString);
        mList.add(jsonObject.getString("success"));

        jsonString = ChangeUserInfoHttp.changeUserGender(gender_url, gender);
        jsonObject = new JSONObject(jsonString);
        mList.add(jsonObject.getString("success"));

        jsonString = ChangeUserInfoHttp.changeUserMobile(mobile_url, mobile);
        jsonObject = new JSONObject(jsonString);
        mList.add(jsonObject.getString("success"));

        for (String s : mList) {
            if(s.equals("false")) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    class GetUserInfoAsync extends AsyncTask<String, Void, ChangeUserInfoVO> {

        @Override
        protected ChangeUserInfoVO doInBackground(String... params) {
            try {
                Log.d("ChangeUserInfoVO", getVOByJsonData().toString());
                return getVOByJsonData();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ChangeUserInfoVO changeUserInfoVO) {
            super.onPostExecute(changeUserInfoVO);

            ChangeUserInfoAdapter adapter = new ChangeUserInfoAdapter(ChangeUserInfoActivity.this, changeUserInfoVO);
            mListView.setAdapter(adapter);
        }
    }

    class ButtonClickAsync extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}
