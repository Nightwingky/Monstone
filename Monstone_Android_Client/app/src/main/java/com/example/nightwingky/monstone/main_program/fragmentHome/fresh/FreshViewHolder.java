package com.example.nightwingky.monstone.main_program.fragmentHome.fresh;

import android.view.View;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.TypeAbstractViewHolder;

/**
 * Created by nightwingky on 17-3-18.
 */

public class FreshViewHolder extends TypeAbstractViewHolder<Object> {

    private TextView tv_fresh;

    public FreshViewHolder(View itemView) {
        super(itemView);

        this.tv_fresh = (TextView) itemView.findViewById(R.id.fresh_home_list);
    }

    @Override
    public void bindHolder(Object object) {

    }
}
