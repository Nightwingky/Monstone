package com.example.nightwingky.monstone.main_program.fragmentHome;

import android.app.Fragment;
import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.freshList.FreshListItemVO;
import com.example.nightwingky.monstone.myConst.HomeConst;
import com.example.nightwingky.monstone.main_program.fragmentHome.itemList.ItemListGridVO;
import com.example.nightwingky.monstone.main_program.fragmentHome.search.GetJsonData;
import com.example.nightwingky.monstone.main_program.fragmentHome.search.SearchHttp;
import com.example.nightwingky.monstone.main_program.fragmentHome.titleBar.TitleBarGridVO;
import com.example.nightwingky.monstone.main_program.productList.ProductListActivity;

import org.json.JSONException;

import java.io.IOException;
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

    private String queryText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_home, container, false);

        mSearchView = (SearchView) view.findViewById(R.id.search_home);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                queryText = String.valueOf(mSearchView.getQuery());
                new SearchAsync().execute();

                InputMethodManager imm = (InputMethodManager) FragmentHome.this.getActivity()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mSearchView.getWindowToken(), 0);
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

    class SearchAsync extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                SearchHttp.mList = GetJsonData.getJsonData(queryText);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if (!aBoolean) {
                Toast.makeText(FragmentHome.this.getActivity(), "查找失败", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(FragmentHome.this.getActivity(), ProductListActivity.class);
                startActivity(intent);
            }
        }
    }
}
