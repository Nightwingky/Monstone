package com.example.nightwingky.monstone.main_program.fragmentShoppingCart;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;

/**
 * Created by nightwingky on 17-3-19.
 */

public class ShoppingCartItemViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_seller;
    private TextView tv_price;
    private TextView tv_title;
    private TextView tv_location;

    private ImageView img_portrait;

//    private Button btn_cancel;
//    private Button btn_submit;

    public ShoppingCartItemViewHolder(View itemView) {
        super(itemView);

        this.tv_seller = (TextView) itemView.findViewById(R.id.seller_shopping_cart_list_item);
        this.tv_price = (TextView) itemView.findViewById(R.id.price_shopping_cart_list_view);
        this.tv_title = (TextView) itemView.findViewById(R.id.title_shopping_cart_list);
        this.tv_location = (TextView) itemView.findViewById(R.id.location_shopping_cart_list_item);
        this.img_portrait = (ImageView) itemView.findViewById(R.id.img_shopping_cart_list);
//        this.btn_cancel = (Button) itemView.findViewById(R.id.btn_submit_shopping_cart_list);
//        this.btn_submit = (Button) itemView.findViewById(R.id.btn_submit_shopping_cart_list);
    }

    public void bindHolder(ShoppingCartListVO shoppingCartListVO) {
        tv_seller.setText(shoppingCartListVO.getSeller());
        tv_price.setText(shoppingCartListVO.getPrice());
        tv_title.setText(shoppingCartListVO.getTitle());
        tv_location.setText(shoppingCartListVO.getLocation());
        img_portrait.setImageResource(R.mipmap.ic_launcher);
    }
}
