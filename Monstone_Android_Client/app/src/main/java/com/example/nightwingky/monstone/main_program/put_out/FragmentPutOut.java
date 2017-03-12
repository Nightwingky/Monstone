package com.example.nightwingky.monstone.main_program.put_out;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nightwingky.monstone.R;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentPutOut extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_put_out, container, false);

        return view;
    }
}
