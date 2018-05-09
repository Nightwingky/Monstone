package com.graduation.nightwingky.book_drifting.monstone.user_action.user_login

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.MainFragmentActivity
import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst
import com.graduation.nightwingky.book_drifting.monstone.user_action.user_forget_pwd.UserForgetPwdActivity
import com.graduation.nightwingky.book_drifting.monstone.user_action.user_register.UserRegisterActivity
import kotlinx.android.synthetic.main.activity_layout_user_login.*

import org.json.JSONException

import java.io.IOException

class UserLoginActivity : AppCompatActivity() {

//    private var edit_username: EditText? = null
//    private var edit_password: EditText? = null
//
//    private var btn_login: Button? = null
//    private var btn_forget_pwd: Button? = null
//    private var btn_register: Button? = null

    private val jsonData: String
        @Throws(IOException::class, JSONException::class)
        get() {
            val jsonString = UserLoginHttp.userLoginQuery(
                    userLoginURL, mEdtLoginUsername!!.text.toString(),
                    mEdtLoginPassword!!.text.toString())

            return jsonString?.let { UserLoginJsonConverter.convertJsonString(it) }.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_user_login)

        bindView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun bindView() {

//        edit_username = findViewById<View>(R.id.mEdtLoginUsername) as EditText
//        edit_password = findViewById<View>(R.id.mEdtLoginPassword) as EditText
//        btn_login = findViewById<View>(R.id.mBtnUserLogin) as Button
//        btn_register = findViewById<View>(R.id.mBtnUserRegister) as Button
//        btn_forget_pwd = findViewById<View>(R.id.mBtnUserForgetPwd) as Button

        mBtnUserLogin!!.setOnClickListener {
//            UserLoginAsyncTask().execute(userLoginURL)
            Toast.makeText(this@UserLoginActivity, "登陆成功", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@UserLoginActivity, MainFragmentActivity::class.java)
            startActivity(intent)
            finish()
        }

        mBtnUserForgetPwd!!.setOnClickListener {
            val intent = Intent(this@UserLoginActivity, UserForgetPwdActivity::class.java)
            startActivity(intent)
        }

        mBtnUserRegister!!.setOnClickListener {
            val intent = Intent(this@UserLoginActivity, UserRegisterActivity::class.java)
            startActivity(intent)
        }
    }

    internal inner class UserLoginAsyncTask : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg params: String): String {

            try {
                return jsonData
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return "false"
        }

        override fun onPostExecute(s: String) {
            super.onPostExecute(s)

            if (s === "true") {
                Toast.makeText(this@UserLoginActivity, "登陆成功", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@UserLoginActivity, MainFragmentActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@UserLoginActivity, "登录失败", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private val userLoginURL = URLConst.user_login_url
    }

}
