package com.example.nightwingky.monstone.main_program.me;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nightwingky.monstone.R;
import com.example.nightwingky.monstone.main_program.me.change_user_info.ChangeUserInfoActivity;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentMe extends Fragment {

    private ListView lv_me;
    private View mLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_layout_me, container, false);

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

        return view;
    }
}
