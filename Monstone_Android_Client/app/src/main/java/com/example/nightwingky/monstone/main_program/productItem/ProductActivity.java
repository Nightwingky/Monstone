package com.example.nightwingky.monstone.main_program.productItem;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

    private ImageView img_portrait;
    private TextView tv_seller;
    private ImageView img_product;
    private TextView tv_title;
    private TextView tv_location;
    private TextView tv_releaseTime;
    private TextView tv_price;
    private Button btn_submit;

    private ProductVO productVO;

    private String no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_information);

        getData();

        initView();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SubmitAsync().execute();
            }
        });
    }

    private void initView() {
        img_portrait = (ImageView) findViewById(R.id.img_portrait_product_item);
        tv_seller = (TextView) findViewById(R.id.seller_product_item);
        img_product = (ImageView) findViewById(R.id.img_product_item);
        tv_title = (TextView) findViewById(R.id.title_product_item);
        tv_location = (TextView) findViewById(R.id.location_product_item);
        tv_releaseTime = (TextView) findViewById(R.id.time_product_item);
        tv_price = (TextView) findViewById(R.id.price_product_item);

        img_portrait.setImageResource(R.mipmap.ic_launcher);
        tv_seller.setText(productVO.getSeller());
        img_product.setImageResource(R.drawable.portrait);
        tv_title.setText(productVO.getName());
        tv_location.setText("来自：" + productVO.getLocation());
        tv_releaseTime.setText("发布时间：" + productVO.getReleaseTime());
        tv_price.setText("￥" + productVO.getPrice());

        btn_submit = (Button) findViewById(R.id.btn_submit_product_info);
    }

    private void getData() {
        Intent intent = getIntent();
        String position = intent.getStringExtra("position");
        this.productVO = SearchHttp.mList.get(Integer.parseInt(position));
        this.no = productVO.getProductId();
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
