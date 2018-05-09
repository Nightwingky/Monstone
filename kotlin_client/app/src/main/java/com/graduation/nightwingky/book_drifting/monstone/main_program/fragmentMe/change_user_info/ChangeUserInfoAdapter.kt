package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.change_user_info

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
 * Created by nightwingky on 17-3-13.
 */

class ChangeUserInfoAdapter(context: Context, changeUserInfoVO: ChangeUserInfoVO) : BaseAdapter() {

    private val mInflater: LayoutInflater

    private val titleList: MutableList<String>
    private val infoList: MutableList<Any>

    init {
        this.mInflater = LayoutInflater.from(context)

        this.titleList = ArrayList()
        this.titleList.add("头像")
        this.titleList.add("昵称")
        this.titleList.add("性别")
        this.titleList.add("生日")
        this.titleList.add("手机")
        this.titleList.add("邮箱")
        this.titleList.add("简介")

        this.infoList = ArrayList()
        this.infoList.add(changeUserInfoVO.portrait!!)
        this.infoList.add(changeUserInfoVO.name!!)
        when (changeUserInfoVO.gender) {
            0 -> this.infoList.add("男")
            1 -> this.infoList.add("女")
            else -> this.infoList.add("保密")
        }
        this.infoList.add(changeUserInfoVO.birth!!)
        this.infoList.add(changeUserInfoVO.mobile.toString())
        this.infoList.add(changeUserInfoVO.email!!)
        this.infoList.add(changeUserInfoVO.introduction!!)
    }

    override fun getCount(): Int {
        return infoList.size
    }

    override fun getItem(position: Int): Any {
        return infoList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var convertView = convertView
        if (position == 0) {
            val viewHolderPortrait = ViewHolderPortrait()
            convertView = mInflater.inflate(R.layout.item_portrait_change_user_info, null)
            viewHolderPortrait.tv_portrait = convertView.findViewById<View>(R.id.tv_portrait_change_user_info) as TextView
            viewHolderPortrait.img_portrait = convertView.findViewById<View>(R.id.img_portrait_change_user_info) as ImageView

            convertView.tag = viewHolderPortrait

            viewHolderPortrait.img_portrait!!.setImageResource(R.drawable.portrait)

            return convertView
        } else {
            val viewHolderElse = ViewHolderElse()
            convertView = mInflater.inflate(R.layout.item_else_change_user_info, null)
            viewHolderElse.tv_else = convertView.findViewById<View>(R.id.tv_else_change_user_info) as TextView
            viewHolderElse.tv_info = convertView.findViewById<View>(R.id.tv_info_else_change_user_info) as TextView

            convertView.tag = viewHolderElse

            viewHolderElse.tv_else!!.text = titleList[position]
            viewHolderElse.tv_info!!.text = infoList[position].toString()

            if (position == 6) {
                viewHolderElse.tv_info!!.text = "生命中，有风，有雨，但别忘了也会有阳光"
            }

            return convertView
        }

    }

    internal inner class ViewHolderPortrait {
        var tv_portrait: TextView? = null
        var img_portrait: ImageView? = null
    }

    internal inner class ViewHolderElse {
        var tv_else: TextView? = null
        var tv_info: TextView? = null
    }
}
