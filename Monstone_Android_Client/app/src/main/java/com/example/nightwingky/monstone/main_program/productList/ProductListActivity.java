package com.example.nightwingky.monstone.main_program.productList;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import com.example.nightwingky.monstone.R;

public class ProductListActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private RecyclerView rv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mSearchView = (SearchView) findViewById(R.id.search_product);
        rv_list = (RecyclerView) findViewById(R.id.recycler_product);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                rv_list.invalidate();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    class SearchAsync extends AsyncTask<String, Void, ProductVO> {

        @Override
        protected ProductVO doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(ProductVO productVO) {
            super.onPostExecute(productVO);
        }
    }
}
