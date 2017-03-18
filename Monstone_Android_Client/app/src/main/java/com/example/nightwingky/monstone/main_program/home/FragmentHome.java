package com.example.nightwingky.monstone.main_program.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.home.homeConst.HomeConst;
import com.example.nightwingky.monstone.main_program.home.itemList.ItemListGridVO;
import com.example.nightwingky.monstone.main_program.home.titleBar.TitleBarGridVO;

import java.util.List;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentHome extends Fragment {

    private RecyclerView rv_home;

    private List<Object> flipperList;
    private List<TitleBarGridVO> titleBarList;
    private List<Object> divideList;
    private List<ItemListGridVO> itemList;

    private FragmentHomeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_home, container, false);

        rv_home = (RecyclerView) view.findViewById(R.id.rv_home);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(FragmentHome.this.getActivity(), 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = rv_home.getAdapter().getItemViewType(position);

                if (type == FragmentHomeAdapter.TYPE_THREE) {
                    return gridLayoutManager.getSpanCount() / 2;
                } else if (type == FragmentHomeAdapter.TYPE_FOUR || type == FragmentHomeAdapter.TYPE_ONE) {
                    return 4;
                } else {
                    return 1;
                }
            }
        });

        rv_home.setLayoutManager(new LinearLayoutManager(FragmentHome.this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_home.setLayoutManager(gridLayoutManager);

        mAdapter = new FragmentHomeAdapter(FragmentHome.this.getActivity());

        rv_home.setAdapter(mAdapter);

        initData();

        return view;
    }

    private void initData() {
        this.flipperList = HomeConst.getFlipper();
        this.titleBarList = HomeConst.getTitleBar();
        this.divideList = HomeConst.getDivide();
        this.itemList = HomeConst.getItem();

        mAdapter.addList(flipperList, titleBarList, divideList, itemList);
        mAdapter.notifyDataSetChanged();
    }

}
