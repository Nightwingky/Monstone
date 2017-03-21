package com.example.nightwingky.monstone.main_program.fragmentMe.transaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.myConst.URLConst;

public class TransactionActivity extends AppCompatActivity {

    private TextView tv_identity;

    private Button btn_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        tv_identity = (TextView) findViewById(R.id.tv_transaction_identity);
        btn_finish = (Button) findViewById(R.id.btn_finish_transaction);

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TransactionActivity.this, "交易完成", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        if (URLConst.getQueky1024_id().equals(URLConst.getUser_id())) {
            tv_identity.setText("买家");
        } else {
            tv_identity.setText("卖家");
        }
    }
}
