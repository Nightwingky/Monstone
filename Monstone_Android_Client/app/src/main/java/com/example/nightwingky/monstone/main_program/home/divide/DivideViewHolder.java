package com.example.nightwingky.monstone.main_program.home.divide;

import android.view.View;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.home.TypeAbstractViewHolder;


/**
 * Created by nightwingky on 17-3-18.
 */

public class DivideViewHolder extends TypeAbstractViewHolder<Object> {

    public View view;

    public DivideViewHolder(View itemView) {
        super(itemView);

        this.view = itemView.findViewById(R.id.home_divided_view);
    }

    @Override
    public void bindHolder(Object object) {

    }
}
