package com.example.nightwingky.monstone.main_program.me.change_user_info;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.me.FragmentMe;
import com.example.nightwingky.monstone.myConst.MyConst;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ChangeUserInfoActivity extends AppCompatActivity {

    private String url = MyConst.getUser_change_info();

    private ListView mListView;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_info);

        bindView();

        new GetUserInfoAsync().execute(url);
    }

    private void bindView() {
        this.mListView = (ListView) findViewById(R.id.lv_change_user_info);
        this.btn_save = (Button) findViewById(R.id.btn_save_change_user_info);
    }

    private ChangeUserInfoVO getJsonData() throws IOException, JSONException {
        String jsonString = ChangeUserInfoHttp.changeUserInfoQuery(url, MyConst.getUser_id());

        JSONObject jsonObject = new JSONObject(jsonString);
        jsonObject = new JSONObject(jsonObject.getString("object"));

        ChangeUserInfoVO changeUserInfoVO = new ChangeUserInfoVO(
                MyConst.getUser_id(),
                jsonObject.getString("name"),
                jsonObject.getInt("gender"),
                jsonObject.getString("birth"),
                jsonObject.getInt("mobile"),
                jsonObject.getString("email"),
                jsonObject.getString("portrait"),
                jsonObject.getString("introduction")
        );

        return changeUserInfoVO;
    }

    class GetUserInfoAsync extends AsyncTask<String, Void, ChangeUserInfoVO> {

        @Override
        protected ChangeUserInfoVO doInBackground(String... params) {
            try {
                Log.d("ChangeUserInfoVO", getJsonData().toString());
                return getJsonData();
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
}
