package com.example.nightwingky.monstone.main_program.fragmentMe;

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
 * Created by nightwingky on 17-3-12.
 */

public class MeListViewAdapter extends BaseAdapter {

    private List<String> mTextList;
    private LayoutInflater mInflater;

    public MeListViewAdapter(Context context) {
        this.mTextList = new ArrayList<String>();
        this.mTextList.add("正在交易");
        this.mTextList.add("我发布的");
        this.mTextList.add("我卖出的");
        this.mTextList.add("我买到的");
        this.mTextList.add("我赞过的");

        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mTextList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTextList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_fragment_home_listview, null);
            viewHolder.tvText = (TextView) convertView.findViewById(R.id.txt_item_listView_home);
            viewHolder.imgIcon = (ImageView) convertView.findViewById(R.id.img_item_listView_home);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imgIcon.setImageResource(R.mipmap.ic_launcher);
        viewHolder.tvText.setText(mTextList.get(position));

        return convertView;
    }

    class ViewHolder {
        public ImageView imgIcon;
        public TextView tvText;
    }
}
