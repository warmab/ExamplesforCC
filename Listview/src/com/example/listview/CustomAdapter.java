package com.example.listview;

import java.util.ArrayList;

import com.example.daylist.Day;
import com.example.daylist.SimpleDate;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils.SimpleStringSplitter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
public class CustomAdapter extends ArrayAdapter<Day>{
    private ArrayList<Day> entries;
    private Activity activity;
 
    public CustomAdapter(Activity a, int textViewResourceId, ArrayList<Day> fetch) {
        super(a, textViewResourceId, fetch);
        this.entries = fetch;
        this.activity = a;
    }
 
    public static class ViewHolder{
        public TextView item1;
        public TextView item2;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            LayoutInflater vi =
                (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.grid_item, null);
            holder = new ViewHolder();
            holder.item1 = (TextView) v.findViewById(R.id.big);
            holder.item2 = (TextView) v.findViewById(R.id.small);
            v.setTag(holder);
        }
        else
            holder=(ViewHolder)v.getTag();
 
        final Day custom = entries.get(position);
        if (custom != null) {
            holder.item1.setText(custom.getSimpleDatesList().toString());
            holder.item2.setText(custom.getColor().toString());
        }
        return v;
    }
 
}