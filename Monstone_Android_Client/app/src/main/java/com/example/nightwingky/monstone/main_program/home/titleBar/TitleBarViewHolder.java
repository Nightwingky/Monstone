package com.example.nightwingky.monstone.main_program.home.titleBar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.home.TypeAbstractViewHolder;


/**
 * Created by nightwingky on 17-3-18.
 */

public class TitleBarViewHolder extends TypeAbstractViewHolder<TitleBarGridVO> {

    public TextView tv_title;
    public TextView tv_introduction;
    public ImageView img_info;

    public TitleBarViewHolder(View itemView) {
        super(itemView);

        tv_title = (TextView) itemView.findViewById(R.id.title_title_bar_grid_home);
        tv_introduction = (TextView) itemView.findViewById(R.id.introduction_title_bar_grid_home);
        img_info = (ImageView) itemView.findViewById(R.id.img_title_bar_grid_home);
    }

    @Override
    public void bindHolder(TitleBarGridVO titleBarGridVO) {
        tv_title.setText(titleBarGridVO.getTitle());
        tv_introduction.setText(titleBarGridVO.getIntroduction());
        img_info.setImageResource(R.mipmap.ic_launcher);
    }
}
