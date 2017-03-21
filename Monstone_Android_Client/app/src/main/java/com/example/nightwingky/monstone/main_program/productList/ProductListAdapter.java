package com.example.nightwingky.monstone.main_program.productList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nightwingky.monstone.R;

import java.util.List;

/**
 * Created by nightwingky on 17-3-19.
 */

public class ProductListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private Context context;

    private LayoutInflater inflater;

    private static List<ProductVO> productVOList;

    private OnRecyclerViewItemListener mOnItemClickListener = null;

    public ProductListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void addList(List<ProductVO> list) {
        this.productVOList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_product_list, parent, false);
        ProductListItemViewHolder viewHolder = new ProductListItemViewHolder(view);

        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ProductListItemViewHolder) holder).bindHolder(productVOList.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return productVOList.size();
    }


    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, String.valueOf(v.getTag()));
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemListener listener) {
        this.mOnItemClickListener = listener;
    }

}
