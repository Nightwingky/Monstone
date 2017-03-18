package com.example.nightwingky.monstone.main_program.put_out;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nightwingky.monstone.R;

import java.io.FileNotFoundException;

import static android.app.Activity.RESULT_OK;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentPutOut extends Fragment {

    private ImageView img_upload1;
    private ImageView img_upload2;
    private ImageView img_upload3;

    private int count;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_put_out, container, false);

        this.img_upload1 = (ImageView) view.findViewById(R.id.img_upload_fragment_put_out1);
        this.img_upload2 = (ImageView) view.findViewById(R.id.img_upload_fragment_put_out2);
        this.img_upload3 = (ImageView) view.findViewById(R.id.img_upload_fragment_put_out3);

        setListener();

        return view;
    }

    private void setListener() {
        img_upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 1;
                startImgActivity();
            }
        });

        img_upload2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 2;
                startImgActivity();
            }
        });

        img_upload3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 3;
                startImgActivity();
            }
        });
    }

    private void startImgActivity() {
        Intent intent = new Intent();
        // 开启Pictures画面Type设定为image
        intent.setType("image/*");
        // 使用Intent.ACTION_GET_CONTENT这个Action
        intent.setAction(Intent.ACTION_GET_CONTENT);
        // 取得相片后返回本画面
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Log.e("uri", uri.toString());
            ContentResolver cr = this.getActivity().getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                switch (count) {
                    case 1:
                        img_upload1.setImageBitmap(bitmap);
                        break;
                    case 2:
                        img_upload2.setImageBitmap(bitmap);
                        break;
                    case 3:
                        img_upload3.setImageBitmap(bitmap);
                        break;
                }

            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(), e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
