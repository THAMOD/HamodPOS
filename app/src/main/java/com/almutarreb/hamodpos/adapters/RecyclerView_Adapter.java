package com.almutarreb.hamodpos.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.almutarreb.hamodpos.R;
import com.almutarreb.hamodpos.model.PRODUCT;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyViewHolder> {
    private Context context;
    ArrayList product_name,quantity,price;
      ;
    private Activity activity;
    public RecyclerView_Adapter(Activity activity, Context context, ArrayList product_name,ArrayList quantity,ArrayList price)
    {
        this.context=context;
        this.product_name=product_name;
        this.quantity=quantity;
        this.price=price;
        this.activity=activity;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Toast.makeText(context, " set text on the items", Toast.LENGTH_SHORT).show();

       holder.product_name.setText(String.valueOf(product_name.get(position)));
        holder.quantity.setText(String.valueOf(quantity.get(position)));
        holder.price.setText(String.valueOf(price.get(position)));

    }

    @Override
    public int getItemCount() {
        return quantity.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView product_name,price,quantity;
        LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            product_name=(itemView).findViewById(R.id.row_product_name);
            price=(itemView).findViewById(R.id.row_price);
            quantity=(itemView).findViewById(R.id.row_quantity);
            layout=(itemView).findViewById(R.id.recycler_layout);
//set anmition fro the layout
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            layout.setAnimation(translate_anim);
        }
    }
}
