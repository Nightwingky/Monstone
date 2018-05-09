package com.graduation.nightwingky.book_drifting.monstone.main_program.productList

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast


import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.search.GetJsonData
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.search.SearchHttp
import com.graduation.nightwingky.book_drifting.monstone.main_program.productItem.ProductActivity

import org.json.JSONException

import java.io.IOException

class ProductListActivity : AppCompatActivity() {

    private var mSearchView: SearchView? = null
    private var rv_list: RecyclerView? = null

    private var adapter: ProductListAdapter? = null

    private var queryText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        mSearchView = findViewById<View>(R.id.search_product) as SearchView
        rv_list = findViewById<View>(R.id.recycler_product) as RecyclerView

        rv_list!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter = ProductListAdapter(this)
        adapter!!.addList(SearchHttp.mList)
        rv_list!!.adapter = adapter
        adapter!!.setOnItemClickListener(object : OnRecyclerViewItemListener {
            override fun onItemClick(view: View, data: String) {
                val intent = Intent(this@ProductListActivity, ProductActivity::class.java)
                intent.putExtra("position", data)
                startActivity(intent)
            }
        })
        adapter!!.notifyDataSetChanged()

        mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                queryText = mSearchView!!.query.toString()
                SearchAsync().execute()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    internal inner class SearchAsync : AsyncTask<String, Void, Boolean>() {

        override fun doInBackground(vararg params: String): Boolean? {
            try {
                SearchHttp.mList = GetJsonData.getJsonData(queryText!!)
                return true
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return false
        }

        override fun onPostExecute(aBoolean: Boolean?) {
            super.onPostExecute(aBoolean)

            if ((!aBoolean!!)!!) {
                Toast.makeText(this@ProductListActivity, "查找失败", Toast.LENGTH_SHORT).show()
            } else {
                adapter!!.addList(SearchHttp.mList)
                adapter!!.notifyDataSetChanged()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(mSearchView!!.windowToken, 0)
            }
        }
    }
}
