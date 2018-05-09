package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.fresh

import android.view.View
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.TypeAbstractViewHolder

/**
 * Created by nightwingky on 17-3-18.
 */

class FreshViewHolder(itemView: View) : TypeAbstractViewHolder<Any>(itemView) {

    private val tv_fresh: TextView

    init {

        this.tv_fresh = itemView.findViewById<View>(R.id.fresh_home_list) as TextView
    }

    override fun bindHolder(`object`: Any) {

    }
}
