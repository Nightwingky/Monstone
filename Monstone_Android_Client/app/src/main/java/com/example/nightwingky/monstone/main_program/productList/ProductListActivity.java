package com.example.nightwingky.monstone.main_program.productList;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.search.GetJsonData;
import com.example.nightwingky.monstone.main_program.fragmentHome.search.SearchHttp;
import com.example.nightwingky.monstone.main_program.product_Item.ProductActivity;

import org.json.JSONException;

import java.io.IOException;

public class ProductListActivity extends AppCompatActivity implements MyItemClickListener{

    private SearchView mSearchView;
    private RecyclerView rv_list;

    private ProductListAdapter adapter;

    private String queryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mSearchView = (SearchView) findViewById(R.id.search_product);
        rv_list = (RecyclerView) findViewById(R.id.recycler_product);

        rv_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new ProductListAdapter(this);
        adapter.addList(SearchHttp.mList);
        rv_list.setAdapter(adapter);
        adapter.setOnItemCLickListener(this);
        adapter.notifyDataSetChanged();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                queryText = String.valueOf(mSearchView.getQuery());
                new SearchAsync().execute();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        String no = SearchHttp.mList.get(position).getProductId();

        Intent intent = new Intent(ProductListActivity.this, ProductActivity.class);
        intent.putExtra("no", no);
        intent.putExtra("position", position);

        startActivity(intent);
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
                Toast.makeText(ProductListActivity.this, "查找失败", Toast.LENGTH_SHORT).show();
            } else {
                adapter.addList(SearchHttp.mList);
                adapter.notifyDataSetChanged();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mSearchView.getWindowToken(), 0) ;
            }
        }
    }
}
