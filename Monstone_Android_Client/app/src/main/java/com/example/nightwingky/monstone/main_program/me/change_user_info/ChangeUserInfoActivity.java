package com.example.nightwingky.monstone.main_program.me.change_user_info;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.myConst.MyConst;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ChangeUserInfoActivity extends AppCompatActivity {

    private String info_url = MyConst.getUser_change_info_url();
    private String name_url = MyConst.getUser_change_name_url();
    private String gender_url = MyConst.getUser_change_gender_url();
    private String mobile_url = MyConst.getUser_change_mobile_url();

    private ListView mListView;
    private Button btn_submit;

    public static ChangeUserInfoActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_info);

        mActivity = ChangeUserInfoActivity.this;

        bindView();

        new GetUserInfoAsync().execute(info_url);
    }

    private void bindView() {
        this.mListView = (ListView) findViewById(R.id.lv_change_user_info);
        this.btn_submit = (Button) findViewById(R.id.btn_submit_change_user_info);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv_title;
                TextView tv_info;
                Intent intent;

                switch (position) {
                    case 1:
                        tv_title = (TextView) view.findViewById(R.id.tv_else_change_user_info);
                        tv_info = (TextView) view.findViewById(R.id.tv_info_else_change_user_info);

                        intent = new Intent(ChangeUserInfoActivity.this, ItemChangeUserInfoActivity.class);
                        intent.putExtra("title", tv_title.getText());
                        intent.putExtra("info", tv_info.getText());
                        intent.putExtra("url", name_url);
                        intent.putExtra("position", position);
                        Log.d("position", String.valueOf(position));
                        startActivity(intent);
                        break;
                    case 2:
                        tv_title = (TextView) view.findViewById(R.id.tv_else_change_user_info);
                        tv_info = (TextView) view.findViewById(R.id.tv_info_else_change_user_info);

                        intent = new Intent(ChangeUserInfoActivity.this, ItemChangeUserInfoActivity.class);
                        intent.putExtra("title", tv_title.getText());
                        intent.putExtra("info", tv_info.getText());
                        intent.putExtra("url", gender_url);
                        intent.putExtra("position", position);
                        Log.d("position", String.valueOf(position));
                        startActivity(intent);
                        break;
                    case 4:
                        tv_title = (TextView) view.findViewById(R.id.tv_else_change_user_info);
                        tv_info = (TextView) view.findViewById(R.id.tv_info_else_change_user_info);

                        intent = new Intent(ChangeUserInfoActivity.this, ItemChangeUserInfoActivity.class);
                        intent.putExtra("title", tv_title.getText());
                        intent.putExtra("info", tv_info.getText());
                        intent.putExtra("url", mobile_url);
                        intent.putExtra("position", position);
                        Log.d("position", String.valueOf(position));
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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

}
