package com.graduation.nightwingky.book_drifting.monstone.main_program.productItem

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.google.gson.Gson
import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.search.SearchHttp
import com.graduation.nightwingky.book_drifting.monstone.main_program.productList.ProductVO
import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

import java.io.IOException
import java.util.ArrayList

class ProductActivity : AppCompatActivity() {

    private var img_portrait: ImageView? = null
    private var tv_seller: TextView? = null
    private var img_product: ImageView? = null
    private var tv_title: TextView? = null
    private var tv_location: TextView? = null
    private var tv_releaseTime: TextView? = null
    private var tv_price: TextView? = null
    private var btn_submit: Button? = null

    private var productVO: ProductVO? = null

    private var no: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_information)

        getData()

        initView()

        btn_submit!!.setOnClickListener { SubmitAsync().execute() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun initView() {
        img_portrait = findViewById<View>(R.id.img_portrait_product_item) as ImageView
        tv_seller = findViewById<View>(R.id.seller_product_item) as TextView
        img_product = findViewById<View>(R.id.img_product_item) as ImageView
        tv_title = findViewById<View>(R.id.title_product_item) as TextView
        tv_location = findViewById<View>(R.id.location_product_item) as TextView
        tv_releaseTime = findViewById<View>(R.id.time_product_item) as TextView
        tv_price = findViewById<View>(R.id.price_product_item) as TextView

        img_portrait!!.setImageResource(R.mipmap.ic_launcher)
        tv_seller!!.text = productVO!!.seller
        img_product!!.setImageResource(R.drawable.portrait)
        tv_title!!.text = productVO!!.name
        tv_location!!.text = "来自：" + productVO!!.location
        tv_releaseTime!!.text = "发布时间：" + productVO!!.releaseTime
        tv_price!!.text = "￥" + productVO!!.price

        btn_submit = findViewById<View>(R.id.btn_submit_product_info) as Button
    }

    private fun getData() {
        val intent = intent
        val position = intent.getStringExtra("position")
        this.productVO = SearchHttp.mList[Integer.parseInt(position)]
        this.no = productVO!!.productId
    }

    internal inner class SubmitAsync : AsyncTask<String, Void, Boolean>() {

        override fun doInBackground(vararg params: String): Boolean? {
            val mList = ArrayList<String>()
            no?.let { mList.add(it) }
            val gson = Gson()
            val jsonString = gson.toJson(mList)

            try {
                ProductHttp.addToCart(URLConst.user_id, jsonString)
                return true
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(aBoolean: Boolean?) {
            super.onPostExecute(aBoolean)

            if (aBoolean!!) {
                Toast.makeText(this@ProductActivity, "添加成功", Toast.LENGTH_SHORT).show()
                this@ProductActivity.finish()
            }
        }
    }

}
