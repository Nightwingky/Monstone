package com.example.nightwingky.monstone.main_program.fragmentShoppingCart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nightwingky.monstone.R;

import java.util.List;

/**
 * Created by nightwingky on 17-3-21.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private LayoutInflater inflater;

    private List<ShoppingCartListVO> listVOs;

    private ShoppingCartItemClickListener listener;

    public ShoppingCartAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void addList(List<ShoppingCartListVO> list) {
        this.listVOs = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_shopping_cart_list, parent, false);
        ShoppingCartItemViewHolder viewHolder = new ShoppingCartItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ShoppingCartItemViewHolder) holder).bindHolder(listVOs.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {

        if (listVOs.size() == 0) {
            return 0;
        } else {
            return listVOs.size();
        }
    }

//    @Override
//    public void onClick(View v) {
//        if(listener != null) {
//            switch (v.getId()) {
//                case R.id.btn_submit_shopping_cart_list:
//                    listener.onItemClick(v,
//                            String.valueOf(v.getTag()), 1);
//                    break;
//                case R.id.btn_cancel_shopping_cart_list:
//                    listener.onItemClick(v,
//                            String.valueOf(v.getTag()), 2);
//                    break;
//                default:
//                    listener.onItemClick(v,
//                            String.valueOf(v.getTag()), 3);
//            }
//        }
//    }
//
//    public void setListener(ShoppingCartItemClickListener mListener) {
//        this.listener = mListener;
//    }
}
