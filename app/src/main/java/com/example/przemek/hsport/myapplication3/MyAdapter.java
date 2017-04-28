package com.example.przemek.hsport.myapplication3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Przemek on 2017-04-28.
 */

public class MyAdapter extends BaseAdapter {

    private Context ctx;

    public Integer[] picture_id = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img2, R.drawable.img3, R.drawable.img1,
            R.drawable.img3, R.drawable.img1, R.drawable.img2
    };

    public MyAdapter(Context c) {
        ctx = c;
    }

    @Override
    public int getCount() {
        return picture_id.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mV;
        if(convertView == null) {
            mV = new ImageView(ctx);
            mV.setLayoutParams(new GridView.LayoutParams(200, 200));
            mV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mV.setPadding(8, 8, 8, 8);
        } else {
            mV = (ImageView) convertView;
        }
        mV.setImageResource(picture_id[position]);

        return mV;
    }
}
