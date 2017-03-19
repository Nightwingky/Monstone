package com.example.nightwingky.monstone.main_program.fragmentHome;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.freshList.FreshListItemVO;
import com.example.nightwingky.monstone.main_program.fragmentHome.homeConst.HomeConst;
import com.example.nightwingky.monstone.main_program.fragmentHome.itemList.ItemListGridVO;
import com.example.nightwingky.monstone.main_program.fragmentHome.titleBar.TitleBarGridVO;
import com.example.nightwingky.monstone.main_program.productList.ProductListActivity;
import com.example.nightwingky.monstone.main_program.productList.ProductVO;

import java.util.List;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentHome extends Fragment {

    private SearchView mSearchView;

    private RecyclerView rv_home;

    private List<Object> flipperList;
    private List<TitleBarGridVO> titleBarList;
    private List<Object> divideList;
    private List<ItemListGridVO> itemList;
    private List<Object> freshList;
    private List<FreshListItemVO> freshListItemVOList;

    private FragmentHomeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_home, container, false);

        mSearchView = (SearchView) view.findViewById(R.id.search_home);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        rv_home = (RecyclerView) view.findViewById(R.id.rv_home);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(FragmentHome.this.getActivity(), 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = rv_home.getAdapter().getItemViewType(position);

                if (type == FragmentHomeAdapter.TYPE_THREE) {
                    return gridLayoutManager.getSpanCount() / 2;
                } else if (type == FragmentHomeAdapter.TYPE_FOUR || type == FragmentHomeAdapter.TYPE_ONE ||
                type == FragmentHomeAdapter.TYPE_FIVE || type == FragmentHomeAdapter.TYPE_SIX) {
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
        this.freshList = HomeConst.getFresh();
        this.freshListItemVOList = HomeConst.getFreshListItemVOList();

        mAdapter.addList(flipperList, titleBarList, divideList, itemList, freshList, freshListItemVOList);
        mAdapter.notifyDataSetChanged();
    }

    class SearchAsync extends AsyncTask<String, Void, ProductVO> {

        @Override
        protected ProductVO doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(ProductVO productVO) {
            super.onPostExecute(productVO);

            Intent intent = new Intent(FragmentHome.this.getActivity(), ProductListActivity.class);
            startActivity(intent);
        }
    }
}
