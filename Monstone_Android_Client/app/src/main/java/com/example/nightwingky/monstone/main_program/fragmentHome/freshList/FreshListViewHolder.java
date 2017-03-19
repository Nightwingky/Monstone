package com.example.nightwingky.monstone.main_program.fragmentHome.freshList;

import android.view.View;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.TypeAbstractViewHolder;

/**
 * Created by nightwingky on 17-3-18.
 */

public class FreshListViewHolder extends TypeAbstractViewHolder<FreshListItemVO> {

    private TextView tv_seller;
    private TextView tv_price;
    private TextView tv_product;

    public FreshListViewHolder(View itemView) {
        super(itemView);

        tv_seller = (TextView) itemView.findViewById(R.id.seller_fresh_home_list_item);
        tv_price = (TextView) itemView.findViewById(R.id.price_fresh_home_list_view);
        tv_product = (TextView) itemView.findViewById(R.id.product_fresh_home_list_view);
    }

    @Override
    public void bindHolder(FreshListItemVO freshListItemVO) {
        tv_seller.setText(freshListItemVO.getSeller());
        tv_price.setText(freshListItemVO.getPrice());
        tv_product.setText(freshListItemVO.getProduct());
    }
}
