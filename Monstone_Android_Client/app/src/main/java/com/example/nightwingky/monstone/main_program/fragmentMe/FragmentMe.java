package com.example.nightwingky.monstone.main_program.fragmentMe;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.fragmentMe.change_user_info.ChangeUserInfoActivity;
import com.example.nightwingky.monstone.main_program.fragmentMe.transaction.TransactionActivity;
import com.example.nightwingky.monstone.myConst.URLConst;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentMe extends Fragment {

    private ListView lv_me;
    private View mLayout;
    private TextView tv_username;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_layout_me, container, false);

        tv_username = (TextView) view.findViewById(R.id.tv_title_fragment_me);

        if (URLConst.getQueky1024_id().equals(URLConst.getUser_id())) {
            tv_username.setText("queky1024");
        } else {
            tv_username.setText("Lance");
        }

        mLayout = view.findViewById(R.id.linear_title_me);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FragmentMe.this.getActivity(), "click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FragmentMe.this.getActivity(), ChangeUserInfoActivity.class);
                startActivity(intent);
            }
        });

        lv_me = (ListView) view.findViewById(R.id.lv_me);
        MeListViewAdapter adapter = new MeListViewAdapter(FragmentMe.this.getActivity());
        lv_me.setAdapter(adapter);

        lv_me.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(FragmentMe.this.getActivity(), TransactionActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}
