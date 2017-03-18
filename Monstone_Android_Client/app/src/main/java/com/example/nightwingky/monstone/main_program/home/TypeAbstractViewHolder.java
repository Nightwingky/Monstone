package com.example.nightwingky.monstone.main_program.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by nightwingky on 17-3-18.
 */

public abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder{
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T object);
}
