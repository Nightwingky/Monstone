package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentShoppingCart

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R

/**
 * Created by nightwingky on 17-3-19.
 */

class ShoppingCartItemViewHolder
//    private Button btn_cancel;
//    private Button btn_submit;

(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tv_seller: TextView
    private val tv_price: TextView
    private val tv_title: TextView
    private val tv_location: TextView

    private val img_portrait: ImageView

    init {
        this.tv_seller = itemView.findViewById<View>(R.id.seller_shopping_cart_list_item) as TextView
        this.tv_price = itemView.findViewById<View>(R.id.price_shopping_cart_list_view) as TextView
        this.tv_title = itemView.findViewById<View>(R.id.title_shopping_cart_list) as TextView
        this.tv_location = itemView.findViewById<View>(R.id.location_shopping_cart_list_item) as TextView
        this.img_portrait = itemView.findViewById<View>(R.id.img_shopping_cart_list) as ImageView
        //        this.btn_cancel = (Button) itemView.findViewById(R.id.btn_submit_shopping_cart_list);
        //        this.btn_submit = (Button) itemView.findViewById(R.id.btn_submit_shopping_cart_list);
    }

    fun bindHolder(shoppingCartListVO: ShoppingCartListVO) {
        tv_seller.text = shoppingCartListVO.seller
        tv_price.text = shoppingCartListVO.price
        tv_title.text = shoppingCartListVO.title
        tv_location.text = shoppingCartListVO.location
        //        img_portrait.setImageResource(R.drawable.portrait2);
    }
}
