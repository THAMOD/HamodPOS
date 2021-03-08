package com.almutarreb.hamodpos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.almutarreb.hamodpos.R;

public class MyCustumAdapter extends BaseAdapter {
    private Context context;
   private String[]columns_name;
    private int[]column_iamges;
    public MyCustumAdapter(Context context, String[] columns_name, int[] column_iamges)
    {
        this.context=context;
        this.columns_name=columns_name;
        this.column_iamges=column_iamges;
    }
    @Override
    public int getCount() {
        return columns_name.length;
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
       LayoutInflater inflater =LayoutInflater.from(context);
       View view =inflater.inflate(R.layout.grid_row,null,false);
        TextView column_name1 =(view).findViewById(R.id.column_name);
        ImageView column_image1=(view).findViewById(R.id.column_image);
        column_name1.setText(columns_name[position]);
        column_image1.setImageResource(column_iamges[position]);
        return view;
    }
}
