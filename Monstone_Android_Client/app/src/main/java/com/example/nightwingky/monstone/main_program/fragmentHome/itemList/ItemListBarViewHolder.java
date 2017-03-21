package com.example.nightwingky.monstone.main_program.fragmentHome.itemList;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.TypeAbstractViewHolder;


/**
 * Created by nightwingky on 17-3-18.
 */

public class ItemListBarViewHolder extends TypeAbstractViewHolder<ItemListGridVO> {

    public TextView tv_title;
    public TextView tv_introduction;
    public ImageView img_src;

    public ItemListBarViewHolder(View itemView) {
        super(itemView);

        tv_title = (TextView) itemView.findViewById(R.id.title_list_item_grid_home);
        tv_introduction = (TextView) itemView.findViewById(R.id.introduction_list_item_grid_home);
        img_src = (ImageView) itemView.findViewById(R.id.img_list_item_grid_home);
    }

    @Override
    public void bindHolder(ItemListGridVO itemListGridVO) {
        tv_title.setText(itemListGridVO.getTitle());
        tv_introduction.setText(itemListGridVO.getIntroduction());
        img_src.setImageResource(itemListGridVO.getImgSrc());
    }
}
