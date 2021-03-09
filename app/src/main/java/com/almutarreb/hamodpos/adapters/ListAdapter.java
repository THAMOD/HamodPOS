package com.almutarreb.hamodpos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.almutarreb.hamodpos.R;
import com.almutarreb.hamodpos.model.PRODUCT;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<PRODUCT> items; //data source of the list adapter

    //public constructor
    public ListAdapter(Context context, ArrayList<PRODUCT> items) {
        this.context = context;
        this.items = items;
    }

    public void AddItem(PRODUCT p) {
        items.add(p);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.list_row, parent, false);
        }

        // get current item to be displayed
        PRODUCT currentItem = (PRODUCT) getItem(position);

        // get the TextView for item name and item description
        TextView product_name = (TextView)
                convertView.findViewById(R.id.row_product_name1);
        TextView quantity = (TextView)
                convertView.findViewById(R.id.row_quantity1);
        TextView price=(TextView)convertView.findViewById(R.id.row_product_name1);

        //sets the text for item name and item description from the current item object
        product_name.setText(currentItem.product_name);
        price.setText(String.valueOf(currentItem.price));
        quantity.setText(String.valueOf(currentItem.quantity));

        // returns the view for the current row
        return convertView;
    }
}