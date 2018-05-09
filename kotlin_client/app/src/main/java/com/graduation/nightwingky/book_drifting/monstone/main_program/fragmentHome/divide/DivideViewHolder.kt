package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.divide

import android.view.View

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.TypeAbstractViewHolder


/**
 * Created by nightwingky on 17-3-18.
 */

class DivideViewHolder(itemView: View) : TypeAbstractViewHolder<Any>(itemView) {

    var view: View

    init {

        this.view = itemView.findViewById(R.id.home_divided_view)
    }

    override fun bindHolder(`object`: Any) {

    }
}
