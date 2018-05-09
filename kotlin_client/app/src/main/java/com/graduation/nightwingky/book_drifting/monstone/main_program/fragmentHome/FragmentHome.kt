package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.freshList.FreshListItemVO
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.itemList.ItemListGridVO
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.search.GetJsonData
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.search.SearchHttp
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.titleBar.TitleBarGridVO
import com.graduation.nightwingky.book_drifting.monstone.main_program.productList.ProductListActivity
import com.graduation.nightwingky.book_drifting.monstone.myConst.HomeConst

import org.json.JSONException

import java.io.IOException

/**
 * Created by nightwingky on 17-3-12.
 */

class FragmentHome : Fragment() {

    private var mSearchView: SearchView? = null

    private var rv_home: RecyclerView? = null

    private var flipperList: List<Any>? = null
    private var titleBarList: List<TitleBarGridVO>? = null
    private var divideList: List<Any>? = null
    private var itemList: List<ItemListGridVO>? = null
    private var freshList: List<Any>? = null
    private var freshListItemVOList: List<FreshListItemVO>? = null

    private var mAdapter: FragmentHomeAdapter? = null

    private var queryText: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle): View? {
        val view = inflater.inflate(R.layout.fragment_layout_home, container, false)

        mSearchView = view.findViewById<View>(R.id.search_home) as SearchView

        mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                queryText = mSearchView!!.query.toString()
                SearchAsync().execute()

                val imm = this@FragmentHome.activity
                        .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(mSearchView!!.windowToken, 0)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        rv_home = view.findViewById<View>(R.id.rv_home) as RecyclerView
        val gridLayoutManager = GridLayoutManager(this@FragmentHome.activity, 4)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val type = rv_home!!.adapter.getItemViewType(position)

                return if (type == FragmentHomeAdapter.TYPE_THREE) {
                    gridLayoutManager.spanCount / 2
                } else if (
                        type == FragmentHomeAdapter.TYPE_FOUR ||
                        type == FragmentHomeAdapter.TYPE_ONE ||
                        type == FragmentHomeAdapter.TYPE_FIVE ||
                        type == FragmentHomeAdapter.TYPE_SIX) {
                    4
                } else {
                    1
                }
            }
        }

        rv_home!!.layoutManager = LinearLayoutManager(
                this@FragmentHome.activity, LinearLayoutManager.VERTICAL, false)
        rv_home!!.layoutManager = gridLayoutManager

        mAdapter = FragmentHomeAdapter(this@FragmentHome.activity)

        rv_home!!.adapter = mAdapter

        initData()

        return view
    }

    private fun initData() {
        this.flipperList = HomeConst.flipper
        this.titleBarList = HomeConst.titleBar
        this.divideList = HomeConst.divide
        this.itemList = HomeConst.item
        this.freshList = HomeConst.fresh
        this.freshListItemVOList = HomeConst.freshListItemVOList

        mAdapter!!.addList(flipperList, titleBarList, divideList,
                itemList, freshList, freshListItemVOList)
        mAdapter!!.notifyDataSetChanged()
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
                Toast.makeText(this@FragmentHome.activity, "查找失败", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@FragmentHome.activity, ProductListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
