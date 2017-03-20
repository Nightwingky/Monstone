package com.example.nightwingky.monstone.main_program.productList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.nightwingky.monstone.R;

import java.util.List;

/**
 * Created by nightwingky on 17-3-19.
 */

public class ProductListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private LayoutInflater inflater;

    private static List<ProductVO> productVOList;

    private MyItemClickListener itemClickListener;

    public ProductListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void addList(List<ProductVO> list) {
        this.productVOList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductListItemViewHolder(inflater.inflate(R.layout.item_product_list, parent, false), itemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ProductListItemViewHolder) holder).bindHolder(productVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return productVOList.size();
    }

    /**
     * 设置ItemClickListener
     * @param listener
     */
    public void setOnItemCLickListener(MyItemClickListener listener) {
        this.itemClickListener = listener;
    }
}
