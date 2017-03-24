package com.example.nightwingky.monstone.main_program.fragmentHome.freshList;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.TypeAbstractViewHolder;
import com.example.nightwingky.monstone.myConst.HomeConst;

import java.util.Random;

/**
 * Created by nightwingky on 17-3-18.
 */

public class FreshListViewHolder extends TypeAbstractViewHolder<FreshListItemVO> {

    private ImageView img_portrait;
    private ImageView img_src1;
    private ImageView img_src2;
    private ImageView img_src3;

    private TextView tv_seller;
    private TextView tv_price;
    private TextView tv_product;

    private Random random = new Random();

    public FreshListViewHolder(View itemView) {
        super(itemView);

        img_portrait = (ImageView) itemView.findViewById(R.id.img_home_new_list_portrait);
        img_src1 = (ImageView) itemView.findViewById(R.id.img1_home_new_list);
        img_src2 = (ImageView) itemView.findViewById(R.id.img2_home_new_list);
        img_src3 = (ImageView) itemView.findViewById(R.id.img3_home_new_list);

        tv_seller = (TextView) itemView.findViewById(R.id.seller_fresh_home_list_item);
        tv_price = (TextView) itemView.findViewById(R.id.price_fresh_home_list_view);
        tv_product = (TextView) itemView.findViewById(R.id.product_fresh_home_list_view);
    }

    @Override
    public void bindHolder(FreshListItemVO freshListItemVO) {

        img_portrait.setImageResource(R.drawable.portrait);
        img_src1.setImageResource(HomeConst.imgSrc[random.nextInt(HomeConst.imgSrc.length)]);
        img_src2.setImageResource(HomeConst.imgSrc[random.nextInt(HomeConst.imgSrc.length)]);
        img_src3.setImageResource(HomeConst.imgSrc[random.nextInt(HomeConst.imgSrc.length)]);
        tv_seller.setText(freshListItemVO.getSeller());
        tv_price.setText(freshListItemVO.getPrice());
        tv_product.setText(freshListItemVO.getProduct());
    }
}
