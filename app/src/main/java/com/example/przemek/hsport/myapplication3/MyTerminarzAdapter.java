package com.example.przemek.hsport.myapplication3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Przemek on 2017-05-07.
 */

public class MyTerminarzAdapter extends BaseAdapter {
    private LayoutInflater inflater = null;
    private Context ctx;
    ArrayList<String> records;

    public MyTerminarzAdapter(Context c, ArrayList<String> r) {
        ctx = c;
        records = r;
    }
    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int position) {
        return records.get(position);
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
        tv1.setText(records.get(position));

        TextView tv2 = (TextView) mV.findViewById(R.id.row_tv2);
        tv2.setText(records.get(position));

        return mV;
    }
}
