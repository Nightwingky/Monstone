package com.example.nightwingky.monstone.main_program.product_Item;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentHome.search.SearchHttp;
import com.example.nightwingky.monstone.main_program.productList.ProductVO;
import com.example.nightwingky.monstone.myConst.URLConst;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private ProductVO productVO;

    private String no;

    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_information);

        getData();

        btn_submit = (Button) findViewById(R.id.btn_submit_product_info);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SubmitAsync().execute();
            }
        });
    }

    private void getData() {
        Intent intent = getIntent();
        no = intent.getStringExtra("no");
        String position = intent.getStringExtra("position");
        this.productVO = SearchHttp.mList.get(Integer.parseInt(position));
    }

    class SubmitAsync extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            List<String> mList = new ArrayList<>();
            mList.add(no);
            Gson gson = new Gson();
            String jsonString = gson.toJson(mList);

            try {
                ProductHttp.addToCart(URLConst.getUser_id(), jsonString);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if(aBoolean) {
                Toast.makeText(ProductActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                ProductActivity.this.finish();
            }
        }
    }

}
