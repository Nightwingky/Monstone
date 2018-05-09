package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.freshList

import android.view.View
import android.widget.ImageView
import android.widget.TextView


import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.TypeAbstractViewHolder
import com.graduation.nightwingky.book_drifting.monstone.myConst.HomeConst

import java.util.Random

/**
 * Created by nightwingky on 17-3-18.
 */

class FreshListViewHolder(itemView: View) : TypeAbstractViewHolder<FreshListItemVO>(itemView) {

    private val img_portrait: ImageView
    private val img_src1: ImageView
    private val img_src2: ImageView
    private val img_src3: ImageView

    private val tv_seller: TextView
    private val tv_price: TextView
    private val tv_product: TextView

    private val random = Random()

    init {

        img_portrait = itemView.findViewById<View>(R.id.img_home_new_list_portrait) as ImageView
        img_src1 = itemView.findViewById<View>(R.id.img1_home_new_list) as ImageView
        img_src2 = itemView.findViewById<View>(R.id.img2_home_new_list) as ImageView
        img_src3 = itemView.findViewById<View>(R.id.img3_home_new_list) as ImageView

        tv_seller = itemView.findViewById<View>(R.id.seller_fresh_home_list_item) as TextView
        tv_price = itemView.findViewById<View>(R.id.price_fresh_home_list_view) as TextView
        tv_product = itemView.findViewById<View>(R.id.product_fresh_home_list_view) as TextView
    }

    override fun bindHolder(freshListItemVO: FreshListItemVO) {

        img_portrait.setImageResource(R.drawable.portrait)
        img_src1.setImageResource(HomeConst.imgSrc[random.nextInt(HomeConst.imgSrc.size)])
        img_src2.setImageResource(HomeConst.imgSrc[random.nextInt(HomeConst.imgSrc.size)])
        img_src3.setImageResource(HomeConst.imgSrc[random.nextInt(HomeConst.imgSrc.size)])
        tv_seller.text = freshListItemVO.seller
        tv_price.text = freshListItemVO.price
        tv_product.text = freshListItemVO.product
    }
}
