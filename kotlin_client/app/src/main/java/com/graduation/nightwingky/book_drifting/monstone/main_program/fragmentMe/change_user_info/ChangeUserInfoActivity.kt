package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.change_user_info

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException

class ChangeUserInfoActivity : AppCompatActivity() {

    private val info_url = URLConst.user_change_info_url
    private val name_url = URLConst.user_change_name_url
    private val gender_url = URLConst.user_change_gender_url
    private val mobile_url = URLConst.user_change_mobile_url

    private var mListView: ListView? = null
    private var btn_submit: Button? = null

    private val voByJsonData: ChangeUserInfoVO
        @Throws(IOException::class, JSONException::class)
        get() {
            val jsonString = ChangeUserInfoHttp.getUserInfo(info_url, URLConst.user_id)

            var jsonObject = JSONObject(jsonString)
            jsonObject = JSONObject(jsonObject.getString("object"))

            return ChangeUserInfoVO(
                    URLConst.user_id,
                    jsonObject.getString("name"),
                    jsonObject.getInt("gender"),
                    jsonObject.getString("birth"),
                    jsonObject.getString("mobile"),
                    jsonObject.getString("email"),
                    jsonObject.getString("portrait"),
                    jsonObject.getString("introduction")
            )
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_user_info)

        mActivity = this@ChangeUserInfoActivity

        bindView()

        GetUserInfoAsync().execute(info_url)
    }

    private fun bindView() {
        this.mListView = findViewById<View>(R.id.lv_change_user_info) as ListView
        this.btn_submit = findViewById<View>(R.id.btn_submit_change_user_info) as Button

        mListView!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val tv_title: TextView
            val tv_info: TextView
            val intent: Intent

            when (position) {
                1 -> {
                    tv_title = view.findViewById<View>(R.id.tv_else_change_user_info) as TextView
                    tv_info = view.findViewById<View>(R.id.tv_info_else_change_user_info) as TextView

                    intent = Intent(this@ChangeUserInfoActivity, ItemChangeUserInfoActivity::class.java)
                    intent.putExtra("title", tv_title.text)
                    intent.putExtra("info", tv_info.text)
                    intent.putExtra("url", name_url)
                    intent.putExtra("position", position)
                    Log.d("position", position.toString())
                    startActivity(intent)
                }
                2 -> {
                    tv_title = view.findViewById<View>(R.id.tv_else_change_user_info) as TextView
                    tv_info = view.findViewById<View>(R.id.tv_info_else_change_user_info) as TextView

                    intent = Intent(this@ChangeUserInfoActivity, ItemChangeUserInfoActivity::class.java)
                    intent.putExtra("title", tv_title.text)
                    intent.putExtra("info", tv_info.text)
                    intent.putExtra("url", gender_url)
                    intent.putExtra("position", position)
                    Log.d("position", position.toString())
                    startActivity(intent)
                }
                4 -> {
                    tv_title = view.findViewById<View>(R.id.tv_else_change_user_info) as TextView
                    tv_info = view.findViewById<View>(R.id.tv_info_else_change_user_info) as TextView

                    intent = Intent(this@ChangeUserInfoActivity, ItemChangeUserInfoActivity::class.java)
                    intent.putExtra("title", tv_title.text)
                    intent.putExtra("info", tv_info.text)
                    intent.putExtra("url", mobile_url)
                    intent.putExtra("position", position)
                    Log.d("position", position.toString())
                    startActivity(intent)
                }
                else -> {
                }
            }
        }

        btn_submit!!.setOnClickListener { finish() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


    internal inner class GetUserInfoAsync : AsyncTask<String, Void, ChangeUserInfoVO>() {

        override fun doInBackground(vararg params: String): ChangeUserInfoVO? {
            try {
                Log.d("ChangeUserInfoVO", voByJsonData.toString())
                return voByJsonData
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(changeUserInfoVO: ChangeUserInfoVO) {
            super.onPostExecute(changeUserInfoVO)

            val adapter = ChangeUserInfoAdapter(this@ChangeUserInfoActivity, changeUserInfoVO)
            mListView!!.adapter = adapter
        }
    }

    companion object {

        lateinit var mActivity: ChangeUserInfoActivity
    }

}
