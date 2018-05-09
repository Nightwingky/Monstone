package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.change_user_info.ChangeUserInfoActivity
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.transaction.TransactionActivity
import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

/**
 * Created by nightwingky on 17-3-12.
 */

class FragmentMe : Fragment() {

    private var lv_me: ListView? = null
    private var mLayout: View? = null
    private var tv_username: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle): View? {
        val view = inflater.inflate(R.layout.fragment_layout_me, container, false)

        tv_username = view.findViewById<View>(R.id.tv_title_fragment_me) as TextView

        if (URLConst.queky1024_id == URLConst.user_id) {
            tv_username!!.text = "queky1024"
        } else {
            tv_username!!.text = "Lance"
        }

        mLayout = view.findViewById(R.id.linear_title_me)
        mLayout!!.setOnClickListener {
            //                Toast.makeText(FragmentMe.this.getActivity(), "click", Toast.LENGTH_SHORT).show();
            val intent = Intent(this@FragmentMe.activity, ChangeUserInfoActivity::class.java)
            startActivity(intent)
        }

        lv_me = view.findViewById<View>(R.id.lv_me) as ListView
        val adapter = MeListViewAdapter(this@FragmentMe.activity)
        lv_me!!.adapter = adapter

        lv_me!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                val intent = Intent(this@FragmentMe.activity, TransactionActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }
}
