package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.itemList

import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.TypeAbstractViewHolder


/**
 * Created by nightwingky on 17-3-18.
 */

class ItemListBarViewHolder(itemView: View) : TypeAbstractViewHolder<ItemListGridVO>(itemView) {

    var tv_title: TextView
    var tv_introduction: TextView
    var img_src: ImageView

    init {

        tv_title = itemView.findViewById<View>(R.id.title_list_item_grid_home) as TextView
        tv_introduction = itemView.findViewById<View>(R.id.introduction_list_item_grid_home) as TextView
        img_src = itemView.findViewById<View>(R.id.img_list_item_grid_home) as ImageView
    }

    override fun bindHolder(itemListGridVO: ItemListGridVO) {
        tv_title.text = itemListGridVO.title
        tv_introduction.text = itemListGridVO.introduction
        img_src.setImageResource(itemListGridVO.imgSrc)
    }
}
