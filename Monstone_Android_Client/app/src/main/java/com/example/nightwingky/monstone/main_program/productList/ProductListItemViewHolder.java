package com.example.nightwingky.monstone.main_program.productList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;

/**
 * Created by nightwingky on 17-3-19.
 */

public class ProductListItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView img_portrait;
    private TextView tv_seller;
    private TextView tv_price;
    private TextView tv_title;
    private TextView tv_location;
    private TextView tv_time;

    public ProductListItemViewHolder(View itemView) {
        super(itemView);

        img_portrait = (ImageView) itemView.findViewById(R.id.img_portrait_product_list_item);
        tv_seller = (TextView) itemView.findViewById(R.id.seller_product_list_item);
        tv_price = (TextView) itemView.findViewById(R.id.price_product_list_view);
        tv_title = (TextView) itemView.findViewById(R.id.title_product_list);
        tv_location = (TextView) itemView.findViewById(R.id.location_product_list_item);
        tv_time = (TextView) itemView.findViewById(R.id.time_product_list_item);
    }

    public void bindHolder(ProductVO productVO) {
        img_portrait.setImageResource(R.mipmap.ic_launcher);
        tv_seller.setText(productVO.getSeller());
        tv_price.setText("￥" + productVO.getPrice());
        tv_title.setText(productVO.getName());
        tv_location.setText(productVO.getLocation());
        tv_time.setText(productVO.getReleaseTime());
    }
}
