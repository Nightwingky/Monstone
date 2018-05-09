package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.titleBar

import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.TypeAbstractViewHolder


/**
 * Created by nightwingky on 17-3-18.
 */

class TitleBarViewHolder(itemView: View) : TypeAbstractViewHolder<TitleBarGridVO>(itemView) {

    var tv_title: TextView
    var tv_introduction: TextView
    var img_info: ImageView

    init {

        tv_title = itemView.findViewById<View>(R.id.title_title_bar_grid_home) as TextView
        tv_introduction = itemView.findViewById<View>(R.id.introduction_title_bar_grid_home) as TextView
        img_info = itemView.findViewById<View>(R.id.img_title_bar_grid_home) as ImageView
    }

    override fun bindHolder(titleBarGridVO: TitleBarGridVO) {
        tv_title.text = titleBarGridVO.title
        tv_introduction.text = titleBarGridVO.introduction
        img_info.setImageResource(titleBarGridVO.imgSrc)
    }
}
