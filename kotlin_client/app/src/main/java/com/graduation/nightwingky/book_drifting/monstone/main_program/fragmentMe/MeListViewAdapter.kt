package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R

import java.util.ArrayList

/**
 * Created by nightwingky on 17-3-12.
 */

class MeListViewAdapter(context: Context) : BaseAdapter() {

    private val mTextList: MutableList<String>
    private val mInflater: LayoutInflater

    init {
        this.mTextList = ArrayList()
        this.mTextList.add("正在交易")
        this.mTextList.add("我发布的")
        this.mTextList.add("我卖出的")
        this.mTextList.add("我买到的")
        this.mTextList.add("我赞过的")

        this.mInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return mTextList.size
    }

    override fun getItem(position: Int): Any {
        return mTextList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var viewHolder: ViewHolder? = null
        if (convertView == null) {
            viewHolder = ViewHolder()
            convertView = mInflater.inflate(R.layout.item_fragment_home_listview, null)
            viewHolder.tvText = convertView!!.findViewById<View>(R.id.txt_item_listView_home) as TextView
            viewHolder.imgIcon = convertView.findViewById<View>(R.id.img_item_listView_home) as ImageView

            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.imgIcon!!.setImageResource(R.mipmap.ic_launcher)
        viewHolder.tvText!!.text = mTextList[position]

        return convertView
    }

    internal inner class ViewHolder {
        var imgIcon: ImageView? = null
        var tvText: TextView? = null
    }
}
