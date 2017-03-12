package com.example.nightwingky.monstone.main_program.me;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nightwingky.monstone.R;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentMe extends Fragment {

    private ListView lv_me;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_layout_me, container, false);
        lv_me = (ListView) view.findViewById(R.id.lv_me);

        MeListViewAdapter adapter = new MeListViewAdapter(FragmentMe.this.getActivity());
        lv_me.setAdapter(adapter);

        return view;
    }
}
