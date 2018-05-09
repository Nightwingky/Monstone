package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentShoppingCart

import android.app.Fragment
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.graduation.nightwingky.book_drifting.R

import org.json.JSONException

import java.io.IOException
import java.util.ArrayList

/**
 * Created by nightwingky on 17-3-12.
 */

class FragmentShoppingCart : Fragment() {

    private var rv_cart: RecyclerView? = null
    private var btn_submit: Button? = null

    private var adapter: ShoppingCartAdapter? = null

    private var listVOs: List<ShoppingCartListVO>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle): View? {
        val view = inflater.inflate(R.layout.fragment_layout_shoppingcart, container, false)

        btn_submit = view.findViewById<View>(R.id.btn_submit_cart) as Button

        btn_submit!!.setOnClickListener {
            adapter!!.addList(ArrayList())
            adapter!!.notifyDataSetChanged()
        }

        rv_cart = view.findViewById<View>(R.id.rv_shoppingCart) as RecyclerView
        rv_cart!!.layoutManager = LinearLayoutManager(this@FragmentShoppingCart.activity, LinearLayoutManager.VERTICAL, false)

        GetContentAsync().execute()

        adapter = ShoppingCartAdapter(this@FragmentShoppingCart.activity)

        return view
    }

    internal inner class GetContentAsync : AsyncTask<String, Void, List<ShoppingCartListVO>>() {

        override fun doInBackground(vararg params: String): List<ShoppingCartListVO>? {
            try {
                listVOs = GetCartJSON.jsonData
                Log.d("listVO", listVOs!!.toString())
                return listVOs
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(shoppingCartListVOs: List<ShoppingCartListVO>) {
            super.onPostExecute(shoppingCartListVOs)

            rv_cart!!.adapter = adapter
            listVOs?.let { adapter!!.addList(it) }

            adapter!!.notifyDataSetChanged()
        }
    }
}

//        adapter.setListener(new ShoppingCartItemClickListener() {
//            @Override
//            public void onItemClick(View view, String position, int data) {
//                Toast.makeText(FragmentShoppingCart.this.getActivity(), "click", Toast.LENGTH_SHORT).show();
//                switch (data) {
//                    case 1:
//                        Toast.makeText(FragmentShoppingCart.this.getActivity(), position + " " + data, Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2:
//                        Toast.makeText(FragmentShoppingCart.this.getActivity(), position + " " + data, Toast.LENGTH_SHORT).show();
//                        break;
//                    default:
//                        Toast.makeText(FragmentShoppingCart.this.getActivity(), position + " " + data, Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
