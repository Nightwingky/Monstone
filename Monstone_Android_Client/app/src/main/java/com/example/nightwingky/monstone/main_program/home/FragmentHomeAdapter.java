package com.example.nightwingky.monstone.main_program.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.home.divide.DivideViewHolder;
import com.example.nightwingky.monstone.main_program.home.itemList.ItemListBarViewHolder;
import com.example.nightwingky.monstone.main_program.home.itemList.ItemListGridVO;
import com.example.nightwingky.monstone.main_program.home.titleBar.TitleBarGridVO;
import com.example.nightwingky.monstone.main_program.home.titleBar.TitleBarViewHolder;
import com.example.nightwingky.monstone.main_program.home.viewFlipper.ViewFlipperViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nightwingky on 17-3-18.
 */

public class FragmentHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;

    private LayoutInflater inflater;

    private List<Object> mFlipperList;
    private List<TitleBarGridVO> mTitleList;
    private List<Object> mDivideList;
    private List<ItemListGridVO> mItemList;

    private Context context;

    private List<Integer> types = new ArrayList<Integer>();
    private Map<Integer, Integer> mPosition = new HashMap<>();

    public FragmentHomeAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void addList(List<Object> flipperList, List<TitleBarGridVO> titleList,
                        List<Object> divideList, List<ItemListGridVO> itemList) {
        addListByType(TYPE_ONE, flipperList);
        addListByType(TYPE_TWO, titleList);
        addListByType(TYPE_FOUR, divideList);
        addListByType(TYPE_THREE, itemList);

        this.mFlipperList = flipperList;
        this.mTitleList = titleList;
        this.mDivideList = divideList;
        this.mItemList = itemList;
    }

    private void addListByType(int type, List list) {
        mPosition.put(type, types.size());

        for (int i = 0; i < list.size(); i++) {
            types.add(type);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ONE:
                return new ViewFlipperViewHolder(context, inflater.inflate(R.layout.home_viewflipper, parent, false));
            case TYPE_TWO:
                return new TitleBarViewHolder(inflater.inflate(R.layout.home_title_bar_grid, parent, false));
            case TYPE_THREE:
                return new ItemListBarViewHolder(inflater.inflate(R.layout.home_list_item_grid, parent, false));
            case TYPE_FOUR:
                return new DivideViewHolder(inflater.inflate(R.layout.home_divide_view, parent, false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int realPosition = position - mPosition.get(viewType);

        switch (viewType) {
            case TYPE_ONE:
                ((ViewFlipperViewHolder) holder).bindHolder(mItemList.get(realPosition));
                break;
            case TYPE_TWO:
                ((TitleBarViewHolder) holder).bindHolder(mTitleList.get(realPosition));
                break;
            case TYPE_THREE:
                ((ItemListBarViewHolder) holder).bindHolder(mItemList.get(realPosition));
                break;
            case TYPE_FOUR:
                ((DivideViewHolder) holder).bindHolder(mDivideList.get(realPosition));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
