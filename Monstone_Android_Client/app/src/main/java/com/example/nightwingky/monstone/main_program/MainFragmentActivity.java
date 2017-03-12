package com.example.nightwingky.monstone.main_program;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.home.FragmentHome;
import com.example.nightwingky.monstone.main_program.me.FragmentMe;
import com.example.nightwingky.monstone.main_program.put_out.FragmentPutOut;
import com.example.nightwingky.monstone.main_program.shoppingCart.FragmentShoppingCart;

public class MainFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_tabHome;
    private TextView tv_tabPutOut;
    private TextView tv_tabShoppingCart;
    private TextView tv_tabSettings;

    private FragmentHome fragmentHome;
    private FragmentPutOut fragmentPutOut;
    private FragmentShoppingCart fragmentShoppingCart;
    private FragmentMe fragmentMe;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        bindView();

        transaction = getFragmentManager().beginTransaction();

        initHomeFragment();
        transaction.commit();
    }

    private void bindView() {
        tv_tabHome = (TextView) findViewById(R.id.txt_home);
        tv_tabPutOut = (TextView) findViewById(R.id.txt_put_out);
        tv_tabShoppingCart = (TextView) findViewById(R.id.txt_shoppingcart);
        tv_tabSettings = (TextView) findViewById(R.id.txt_me);

        tv_tabHome.setOnClickListener(this);
        tv_tabPutOut.setOnClickListener(this);
        tv_tabShoppingCart.setOnClickListener(this);
        tv_tabSettings.setOnClickListener(this);
    }

    private void initHomeFragment() {
        hideAllFragment(transaction);

        setUnselected();
        tv_tabHome.setSelected(true);

        fragmentHome = new FragmentHome();
        transaction.add(R.id.fragment_container, fragmentHome);
    }

    private void setUnselected() {
        tv_tabHome.setSelected(false);
        tv_tabPutOut.setSelected(false);
        tv_tabShoppingCart.setSelected(false);
        tv_tabSettings.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if(fragmentHome != null){
            transaction.hide(fragmentHome);
        }
        if(fragmentPutOut != null){
            transaction.hide(fragmentPutOut);
        }
        if(fragmentShoppingCart != null){
            transaction.hide(fragmentShoppingCart);
        }
        if(fragmentMe != null){
            transaction.hide(fragmentMe);
        }
    }

    @Override
    public void onClick(View v) {
        transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);

        switch (v.getId()) {
            case R.id.txt_home:
                setUnselected();
                tv_tabHome.setSelected(true);

                if(fragmentHome == null) {
                    fragmentHome = new FragmentHome();
                    transaction.add(R.id.fragment_container, fragmentHome);
                } else {
                    transaction.show(fragmentHome);
                }
                break;
            case R.id.txt_put_out:
                setUnselected();
                tv_tabPutOut.setSelected(true);

                if(fragmentPutOut == null) {
                    fragmentPutOut = new FragmentPutOut();
                    transaction.add(R.id.fragment_container, fragmentPutOut);
                } else {
                    transaction.show(fragmentPutOut);
                }
                break;
            case R.id.txt_shoppingcart:
                setUnselected();
                tv_tabShoppingCart.setSelected(true);

                if(fragmentShoppingCart == null) {
                    fragmentShoppingCart = new FragmentShoppingCart();
                    transaction.add(R.id.fragment_container, fragmentShoppingCart);
                } else {
                    transaction.show(fragmentShoppingCart);
                }
                break;
            case R.id.txt_me:
                setUnselected();
                tv_tabSettings.setSelected(true);

                if(fragmentMe == null) {
                    fragmentMe = new FragmentMe();
                    transaction.add(R.id.fragment_container, fragmentMe);
                } else {
                    transaction.show(fragmentMe);
                }
                break;
        }

        transaction.commit();
    }
}