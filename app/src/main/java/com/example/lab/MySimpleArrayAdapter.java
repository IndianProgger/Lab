package com.example.lab;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.list, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list, parent, false);
        TextView textView = rowView.findViewById(R.id.label);
        LinearLayout linearLayout = rowView.findViewById(R.id.list1);
        textView.setText(values[position]);
        if (position%2==0) {
            linearLayout.setBackgroundColor(Color.parseColor("#928E8E"));
        } else {
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        return rowView;
    }
}
