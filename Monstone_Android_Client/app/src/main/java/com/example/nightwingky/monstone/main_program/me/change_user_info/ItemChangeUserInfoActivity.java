package com.example.nightwingky.monstone.main_program.me.change_user_info;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nightwingky.monstone.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ItemChangeUserInfoActivity extends AppCompatActivity {

    private TextView tv_title;
    private EditText edit_info;
    private Button btn_submit;

    private String title;
    private String info;
    private String url;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_change_user_info);

        bindView();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info = String.valueOf(edit_info.getText());
                new SubmitAsync().execute();
                ChangeUserInfoActivity.mActivity.recreate();
                finish();
            }
        });
    }

    private void bindView() {
        tv_title = (TextView) findViewById(R.id.tv_item_change_user_info);
        edit_info = (EditText) findViewById(R.id.edit_info_item_change_user_info);
        btn_submit = (Button) findViewById(R.id.btn_item_change_user_info);

        Intent intent = getIntent();
        this.title = intent.getStringExtra("title");
        this.info = intent.getStringExtra("info");
        this.url = intent.getStringExtra("url");
        this.position = intent.getIntExtra("position", 0);

        tv_title.setText(title);
        edit_info.setText(info);
    }

    class SubmitAsync extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            boolean flag = false;

            switch (position) {
                case 1:
                    try {
                        String jsonString = ChangeUserInfoHttp.changeUserName(url, info);
                        Log.d("jsonString", jsonString);
                        JSONObject jsonObject = new JSONObject(jsonString);
                        if (jsonObject.getString("success").equals("true")) {
                            flag = true;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        String jsonString = ChangeUserInfoHttp.changeUserGender(url, info);
                        Log.d("jsonString", jsonString);
                        JSONObject jsonObject = new JSONObject(jsonString);
                        if (jsonObject.getString("success").equals("true")) {
                            flag = true;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        String jsonString = ChangeUserInfoHttp.changeUserMobile(url, info);
                        Log.d("jsonString", jsonString);
                        JSONObject jsonObject = new JSONObject(jsonString);
                        if (jsonObject.getString("success").equals("true")) {
                            flag = true;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }

            return flag;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if (aBoolean) {
                Toast.makeText(ItemChangeUserInfoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ItemChangeUserInfoActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
