package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by nightwingky on 17-3-18.
 */

abstract class TypeAbstractViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindHolder(`object`: T)
}
