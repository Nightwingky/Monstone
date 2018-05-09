package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentShoppingCart

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.graduation.nightwingky.book_drifting.R

/**
 * Created by nightwingky on 17-3-21.
 */

class ShoppingCartAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater: LayoutInflater

    private var listVOs: List<ShoppingCartListVO>? = null

    private val listener: ShoppingCartItemClickListener? = null

    init {
        this.inflater = LayoutInflater.from(context)
    }

    fun addList(list: List<ShoppingCartListVO>) {
        this.listVOs = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = inflater.inflate(R.layout.item_shopping_cart_list, parent, false)

        return ShoppingCartItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ShoppingCartItemViewHolder).bindHolder(listVOs!![position])
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {

        return if (listVOs!!.size == 0) {
            0
        } else {
            listVOs!!.size
        }
    }

    //    @Override
    //    public void onClick(View v) {
    //        if(listener != null) {
    //            switch (v.getId()) {
    //                case R.id.btn_submit_shopping_cart_list:
    //                    listener.onItemClick(v,
    //                            String.valueOf(v.getTag()), 1);
    //                    break;
    //                case R.id.btn_cancel_shopping_cart_list:
    //                    listener.onItemClick(v,
    //                            String.valueOf(v.getTag()), 2);
    //                    break;
    //                default:
    //                    listener.onItemClick(v,
    //                            String.valueOf(v.getTag()), 3);
    //            }
    //        }
    //    }
    //
    //    public void setListener(ShoppingCartItemClickListener mListener) {
    //        this.listener = mListener;
    //    }
}
