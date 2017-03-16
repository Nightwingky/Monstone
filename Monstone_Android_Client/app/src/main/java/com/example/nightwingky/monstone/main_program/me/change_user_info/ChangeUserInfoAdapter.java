package com.example.nightwingky.monstone.main_program.me.change_user_info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 17-3-13.
 */

public class ChangeUserInfoAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private List<String> titleList;
    private List<Object> infoList;

    public ChangeUserInfoAdapter(Context context, ChangeUserInfoVO changeUserInfoVO) {
        this.mInflater = LayoutInflater.from(context);

        this.titleList = new ArrayList<String>();
        this.titleList.add("头像");
        this.titleList.add("昵称");
        this.titleList.add("性别");
        this.titleList.add("生日");
        this.titleList.add("手机");
        this.titleList.add("邮箱");
        this.titleList.add("简介");

        this.infoList = new ArrayList<Object>();
        this.infoList.add(changeUserInfoVO.getPortrait());
        this.infoList.add(changeUserInfoVO.getName());
        switch (changeUserInfoVO.getGender()) {
            case 0:
                this.infoList.add("男");
                break;
            case 1:
                this.infoList.add("女");
                break;
            default:
                this.infoList.add("保密");
                break;
        }
        this.infoList.add(changeUserInfoVO.getBirth());
        this.infoList.add(String.valueOf(changeUserInfoVO.getMobile()));
        this.infoList.add(changeUserInfoVO.getEmail());
        this.infoList.add(changeUserInfoVO.getIntroduction());
    }

    @Override
    public int getCount() {
        return infoList.size();
    }

    @Override
    public Object getItem(int position) {
        return infoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position == 0) {
            ViewHolderPortrait viewHolderPortrait= new ViewHolderPortrait();
            convertView = mInflater.inflate(R.layout.item_portrait_change_user_info, null);
            viewHolderPortrait.tv_portrait = (TextView) convertView.findViewById(R.id.tv_portrait_change_user_info);
            viewHolderPortrait.img_portrait = (ImageView) convertView.findViewById(R.id.img_portrait_change_user_info);

            convertView.setTag(viewHolderPortrait);

            viewHolderPortrait.img_portrait.setImageResource(R.mipmap.ic_launcher);

            return convertView;
        } else {
            ViewHolderElse viewHolderElse = new ViewHolderElse();
            convertView = mInflater.inflate(R.layout.item_else_change_user_info, null);
            viewHolderElse.tv_else = (TextView) convertView.findViewById(R.id.tv_else_change_user_info);
            viewHolderElse.tv_info = (TextView) convertView.findViewById(R.id.tv_info_else_change_user_info);

            convertView.setTag(viewHolderElse);

            viewHolderElse.tv_else.setText(titleList.get(position));
            viewHolderElse.tv_info.setText(String.valueOf(infoList.get(position)));

            if (position == 6) {
                viewHolderElse.tv_info.setText("生命中，有风，有雨，但别忘了也会有阳光");
            }

            return convertView;
        }

    }

    class ViewHolderPortrait {
        public TextView tv_portrait;
        public ImageView img_portrait;
    }

    class ViewHolderElse {
        public TextView tv_else;
        public TextView tv_info;
    }
}
