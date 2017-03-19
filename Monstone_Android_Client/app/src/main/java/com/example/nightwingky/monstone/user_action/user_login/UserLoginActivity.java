package com.example.nightwingky.monstone.user_action.user_login;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.MainFragmentActivity;
import com.example.nightwingky.monstone.myConst.URLConst;
import com.example.nightwingky.monstone.user_action.user_forget_pwd.UserForgetPwdActivity;
import com.example.nightwingky.monstone.user_action.user_register.UserRegisterActivity;

import org.json.JSONException;

import java.io.IOException;

public class UserLoginActivity extends AppCompatActivity {

    private EditText edit_username;
    private EditText edit_password;

    private Button btn_login;
    private Button btn_forget_pwd;
    private Button btn_register;

    private static String userLoginURL = URLConst.getUser_login_url();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_user_login);

        bindView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void bindView() {

        edit_username = (EditText) findViewById(R.id.editText_login_username);
        edit_password = (EditText) findViewById(R.id.editText_login_pwd);
        btn_login = (Button) findViewById(R.id.btn_login_login);
        btn_register = (Button) findViewById(R.id.btn_login_register);
        btn_forget_pwd = (Button) findViewById(R.id.btn_login_forgetPwd);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UserLoginAsyncTask().execute(userLoginURL);
            }
        });

        btn_forget_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLoginActivity.this, UserForgetPwdActivity.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLoginActivity.this, UserRegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private String getJsonData() throws IOException, JSONException {
        String jsonString = UserLoginHttp.userLoginQuery(
                userLoginURL, edit_username.getText().toString(),
                edit_password.getText().toString());

        String success = UserLoginJsonConverter.convertJsonString(jsonString);

        return success;
    }

    class UserLoginAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try {
                return getJsonData();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return "false";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if(s == "true") {
                Toast.makeText(UserLoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserLoginActivity.this, MainFragmentActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(UserLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
