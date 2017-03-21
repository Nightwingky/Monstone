package com.example.nightwingky.monstone.main_program.fragmentShoppingCart;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nightwingky.monstone.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentShoppingCart extends Fragment {

    private RecyclerView rv_cart;

    private ShoppingCartAdapter adapter;

    private List<ShoppingCartListVO> listVOs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_shoppingcart, container, false);

        rv_cart = (RecyclerView) view.findViewById(R.id.rv_shoppingCart);
        rv_cart.setLayoutManager(new LinearLayoutManager(FragmentShoppingCart.this.getActivity(), LinearLayoutManager.VERTICAL, false));

        new GetContentAsync().execute();

        adapter = new ShoppingCartAdapter(FragmentShoppingCart.this.getActivity());

        return view;
    }



    class GetContentAsync extends AsyncTask<String, Void, List<ShoppingCartListVO>> {

        @Override
        protected List<ShoppingCartListVO> doInBackground(String... params) {
            try {
                listVOs = GetCartJSON.getJsonData();
                Log.d("listVO", listVOs.toString());
                return listVOs;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<ShoppingCartListVO> shoppingCartListVOs) {
            super.onPostExecute(shoppingCartListVOs);

            rv_cart.setAdapter(adapter);
            adapter.addList(listVOs);
            adapter.notifyDataSetChanged();
        }
    }
}
