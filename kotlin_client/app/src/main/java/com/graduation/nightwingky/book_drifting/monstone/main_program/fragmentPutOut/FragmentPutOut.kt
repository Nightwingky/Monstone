package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentPutOut

import android.app.Fragment
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

import com.graduation.nightwingky.book_drifting.R

import org.json.JSONException
import org.json.JSONObject

import java.io.FileNotFoundException
import java.io.IOException

import android.app.Activity.RESULT_OK

/**
 * Created by nightwingky on 17-3-12.
 */

class FragmentPutOut : Fragment(), View.OnClickListener {

    private var img_upload1: ImageView? = null
    private var img_upload2: ImageView? = null
    private var img_upload3: ImageView? = null

    private var btn_submit: Button? = null

    private var edit_name: EditText? = null
    private var edit_price: EditText? = null
    private var edit_catalog: EditText? = null

    private var count: Int = 0

    private var name: String? = null
    private var price: String? = null
    private var catalog: String? = null

    private val jsonData: String
        @Throws(IOException::class, JSONException::class)
        get() {
            val jsonString = name?.let { price?.let { it1 -> catalog?.let { it2 -> PutOutHttp.putOut(it, it1, it2) } } }

            val jsonObject = JSONObject(jsonString)

            return jsonObject.getString("success")
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle): View? {
        val view = inflater.inflate(R.layout.fragment_layout_put_out, container, false)

        this.img_upload1 = view.findViewById<View>(R.id.img_upload_fragment_put_out1) as ImageView
        this.img_upload2 = view.findViewById<View>(R.id.img_upload_fragment_put_out2) as ImageView
        this.img_upload3 = view.findViewById<View>(R.id.img_upload_fragment_put_out3) as ImageView

        this.btn_submit = view.findViewById<View>(R.id.btn_submit_put_out) as Button

        this.edit_name = view.findViewById<View>(R.id.edit_name_put_out) as EditText
        this.edit_price = view.findViewById<View>(R.id.edit_price_put_out) as EditText
        this.edit_catalog = view.findViewById<View>(R.id.edit_catalog_put_out) as EditText

        btn_submit!!.setOnClickListener {
            getText()
            PutOutAsyncTask().execute()
        }

        return view
    }

    private fun getText() {
        this.name = edit_name!!.text.toString()
        this.price = edit_price!!.text.toString()
        this.catalog = edit_catalog!!.text.toString()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_upload_fragment_put_out1 -> {
                count = 1
                startImgActivity()
            }
            R.id.img_upload_fragment_put_out2 -> {
                count = 2
                startImgActivity()
            }
            R.id.img_upload_fragment_put_out3 -> {
                count = 3
                startImgActivity()
            }
        }
    }

    private fun startImgActivity() {
        val intent = Intent()
        // 开启Pictures画面Type设定为image
        intent.type = "image/*"
        // 使用Intent.ACTION_GET_CONTENT这个Action
        intent.action = Intent.ACTION_GET_CONTENT
        // 取得相片后返回本画面
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            val uri = data.data
            Log.e("uri", uri!!.toString())
            val cr = this.activity.contentResolver
            try {
                val bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri))
                when (count) {
                    1 -> img_upload1!!.setImageBitmap(bitmap)
                    2 -> img_upload2!!.setImageBitmap(bitmap)
                    3 -> img_upload3!!.setImageBitmap(bitmap)
                }

            } catch (e: FileNotFoundException) {
                Log.e("Exception", e.message, e)
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    internal inner class PutOutAsyncTask : AsyncTask<String, Void, Boolean>() {

        override fun doInBackground(vararg params: String): Boolean? {

            try {
                if (jsonData == "true") {
                    return true
                }
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return false
        }

        override fun onPostExecute(aBoolean: Boolean?) {
            super.onPostExecute(aBoolean)

            if (aBoolean == true) {
                Toast.makeText(this@FragmentPutOut.activity, "发布成功", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this@FragmentPutOut.activity, "发布失败，请稍后再尝试", Toast.LENGTH_SHORT).show()
            }
        }
    }
}