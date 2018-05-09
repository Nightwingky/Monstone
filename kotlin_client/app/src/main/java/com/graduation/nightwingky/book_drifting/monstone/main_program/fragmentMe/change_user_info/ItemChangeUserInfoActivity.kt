package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.change_user_info

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.graduation.nightwingky.book_drifting.R

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException

class ItemChangeUserInfoActivity : AppCompatActivity() {

    private var tv_title: TextView? = null
    private var edit_info: EditText? = null
    private var btn_submit: Button? = null

    private var title: String? = null
    private var info: String? = null
    private var url: String? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_change_user_info)

        bindView()

        btn_submit!!.setOnClickListener {
            info = edit_info!!.text.toString()
            SubmitAsync().execute()
            ChangeUserInfoActivity.mActivity.recreate()
            finish()
        }
    }

    private fun bindView() {
        tv_title = findViewById<View>(R.id.tv_item_change_user_info) as TextView
        edit_info = findViewById<View>(R.id.edit_info_item_change_user_info) as EditText
        btn_submit = findViewById<View>(R.id.btn_item_change_user_info) as Button

        val intent = intent
        this.title = intent.getStringExtra("title")
        this.info = intent.getStringExtra("info")
        this.url = intent.getStringExtra("url")
        this.position = intent.getIntExtra("position", 0)

        tv_title!!.text = title
        edit_info!!.setText(info)
    }

    internal inner class SubmitAsync : AsyncTask<String, Void, Boolean>() {

        override fun doInBackground(vararg params: String): Boolean? {
            var flag = false

            when (position) {
                1 -> try {
                    val jsonString = ChangeUserInfoHttp.changeUserName(url!!, info!!)
                    Log.d("jsonString", jsonString)
                    val jsonObject = JSONObject(jsonString)
                    if (jsonObject.getString("success") == "true") {
                        flag = true
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                2 -> try {
                    val jsonString = ChangeUserInfoHttp.changeUserGender(url!!, info!!)
                    Log.d("jsonString", jsonString)
                    val jsonObject = JSONObject(jsonString)
                    if (jsonObject.getString("success") == "true") {
                        flag = true
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                4 -> try {
                    val jsonString = ChangeUserInfoHttp.changeUserMobile(url!!, info!!)
                    Log.d("jsonString", jsonString)
                    val jsonObject = JSONObject(jsonString)
                    if (jsonObject.getString("success") == "true") {
                        flag = true
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                else -> {
                }
            }

            return flag
        }

        override fun onPostExecute(aBoolean: Boolean?) {
            super.onPostExecute(aBoolean)

            if (aBoolean!!) {
                Toast.makeText(this@ItemChangeUserInfoActivity, "修改成功", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@ItemChangeUserInfoActivity, "修改失败", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
