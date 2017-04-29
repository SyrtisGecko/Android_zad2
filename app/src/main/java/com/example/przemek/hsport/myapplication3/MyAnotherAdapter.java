package com.example.przemek.hsport.myapplication3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Przemek on 2017-04-29.
 */

public class MyAnotherAdapter extends BaseAdapter {
    private LayoutInflater inflater = null;
    private Context ctx;

    String[] ltxt1 = {"Position One", "Position Two", "Position Three", "Position Four", "Position Five",
            "Position Six", "Position Seven", "Position Eight", "Position Nine", "Position Ten"};
    String[] ltxt2 = {"Text 1", "Text 2", "Text 3", "Text 4", "Text 5", "Text 6", "Text 7", "Text 8", "Text 9", "Text 0"};

    public MyAnotherAdapter(Context c) {
        ctx = c;
    }
    @Override
    public int getCount() {
        return ltxt1.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mV;
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
        }
        mV = convertView;

        TextView tv1 = (TextView) mV.findViewById(R.id.row_tv1);
        tv1.setText(ltxt1[position]);

        TextView tv2 = (TextView) mV.findViewById(R.id.row_tv2);
        tv2.setText(ltxt2[position]);

        return mV;
    }
}
