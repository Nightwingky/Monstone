package com.graduation.nightwingky.book_drifting.monstone.main_program.productList

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.myConst.LocationConst

/**
 * Created by nightwingky on 17-3-19.
 */

class ProductListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val img_portrait: ImageView
    private val tv_seller: TextView
    private val tv_price: TextView
    private val tv_title: TextView
    private val tv_location: TextView
    private val tv_time: TextView

    init {
        img_portrait = itemView.findViewById<View>(R.id.img_portrait_product_list_item) as ImageView
        tv_seller = itemView.findViewById<View>(R.id.seller_product_list_item) as TextView
        tv_price = itemView.findViewById<View>(R.id.price_product_list_view) as TextView
        tv_title = itemView.findViewById<View>(R.id.title_product_list) as TextView
        tv_location = itemView.findViewById<View>(R.id.location_product_list_item) as TextView
        tv_time = itemView.findViewById<View>(R.id.time_product_list_item) as TextView

    }

    fun bindHolder(productVO: ProductVO) {
        img_portrait.setImageResource(R.drawable.portrait2)
        tv_seller.text = productVO.seller
        tv_price.text = "￥" + productVO.price
        tv_title.text = productVO.name
        productVO.location = LocationConst.randomLoc
        tv_location.text = productVO.location
        tv_time.text = productVO.releaseTime
    }

}
