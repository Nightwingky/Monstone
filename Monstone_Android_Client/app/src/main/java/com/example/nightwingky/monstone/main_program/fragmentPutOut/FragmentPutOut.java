package com.example.nightwingky.monstone.main_program.fragmentPutOut;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nightwingky.monstone.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

/**
 * Created by nightwingky on 17-3-12.
 */

public class FragmentPutOut extends Fragment implements View.OnClickListener{

    private ImageView img_upload1;
    private ImageView img_upload2;
    private ImageView img_upload3;

    private Button btn_submit;

    private EditText edit_name;
    private EditText edit_price;
    private EditText edit_catalog;

    private int count;

    private String name;
    private String price;
    private String catalog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_put_out, container, false);

        this.img_upload1 = (ImageView) view.findViewById(R.id.img_upload_fragment_put_out1);
        this.img_upload2 = (ImageView) view.findViewById(R.id.img_upload_fragment_put_out2);
        this.img_upload3 = (ImageView) view.findViewById(R.id.img_upload_fragment_put_out3);

        this.btn_submit = (Button) view.findViewById(R.id.btn_submit_put_out);

        this.edit_name = (EditText) view.findViewById(R.id.edit_name_put_out);
        this.edit_price = (EditText) view.findViewById(R.id.edit_price_put_out);
        this.edit_catalog = (EditText) view.findViewById(R.id.edit_catalog_put_out);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getText();
                new PutOutAsyncTask().execute();
            }
        });

        return view;
    }

    private void getText() {
        this.name = String.valueOf(edit_name.getText());
        this.price = String.valueOf(edit_price.getText());
        this.catalog = String.valueOf(edit_catalog.getText());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_upload_fragment_put_out1:
                count = 1;
                startImgActivity();
                break;
            case R.id.img_upload_fragment_put_out2:
                count = 2;
                startImgActivity();
                break;
            case R.id.img_upload_fragment_put_out3:
                count = 3;
                startImgActivity();
                break;
        }
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

    private String getJsonData() throws IOException, JSONException {
        String jsonString = PutOutHttp.putOut(name, price, catalog);

        JSONObject jsonObject = new JSONObject(jsonString);
        String success = jsonObject.getString("success");

        return success;
    }

    class PutOutAsyncTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {

            try {
                if (getJsonData().equals("true")) {
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if (aBoolean == true) {
                Toast.makeText(FragmentPutOut.this.getActivity(), "发布成功", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(FragmentPutOut.this.getActivity(), "发布失败，请稍后再尝试", Toast.LENGTH_SHORT).show();
            }
        }
    }
}