package com.graduation.nightwingky.book_drifting.monstone.main_program.productList

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.graduation.nightwingky.book_drifting.R

/**
 * Created by nightwingky on 17-3-19.
 */

class ProductListAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener {

    private val inflater: LayoutInflater

    private var mOnItemClickListener: OnRecyclerViewItemListener? = null

    private var productVOList: List<ProductVO>? = null

    init {
        this.inflater = LayoutInflater.from(context)
    }

    fun addList(list: List<ProductVO>) {
        this.productVOList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = inflater.inflate(R.layout.item_product_list, parent, false)
        val viewHolder = ProductListItemViewHolder(view)

        view.setOnClickListener(this)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductListItemViewHolder).bindHolder(productVOList!![position])
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return productVOList!!.size
    }


    override fun onClick(v: View) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener!!.onItemClick(v, v.tag.toString())
        }
    }

    fun setOnItemClickListener(listener: OnRecyclerViewItemListener) {
        this.mOnItemClickListener = listener
    }

}
