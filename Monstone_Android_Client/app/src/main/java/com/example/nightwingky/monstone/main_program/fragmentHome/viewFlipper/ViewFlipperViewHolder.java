package com.example.nightwingky.monstone.main_program.fragmentHome.viewFlipper;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.TypeAbstractViewHolder;


/**
 * Created by nightwingky on 17-3-18.
 */

public class ViewFlipperViewHolder extends TypeAbstractViewHolder<Object> {


    private ViewFlipper flipper;

    private int[] resId = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
    };

    private float startX;

    private Context context;

    public ViewFlipperViewHolder(final Context context, View itemView) {
        super(itemView);

        this.context = context;

        flipper = (ViewFlipper) itemView.findViewById(R.id.home_viewFlipper);

        flipper.setInAnimation(context, R.anim.left_in);
        flipper.setOutAnimation(context, R.anim.left_out);

        flipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //向左还是向右
                        if(event.getX()-startX > 100)
                        {
                            flipper.setInAnimation(context, R.anim.left_in);
                            flipper.setOutAnimation(context, R.anim.left_out);
                            flipper.showPrevious();//前一页
                        }
                        else if (startX - event.getX() > 100)
                        {
                            flipper.setInAnimation(context, R.anim.right_in);
                            flipper.setOutAnimation(context, R.anim.right_out);
                            flipper.showNext();//后一页
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }
        });
    }

    private ImageView getImageView(int resId) {
        ImageView image = new ImageView(context);
        image.setBackgroundResource(resId);
        return image;
    }

    @Override
    public void bindHolder(Object object) {
        for (int i = 0; i < resId.length; i++) {
            flipper.addView(getImageView(resId[i]));
        }
        flipper.setFlipInterval(5000);
        flipper.startFlipping();
    }
}
