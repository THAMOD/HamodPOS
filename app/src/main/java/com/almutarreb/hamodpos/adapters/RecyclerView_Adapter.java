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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.almutarreb.hamodpos.model.PRODUCT;

import com.almutarreb.hamodpos.R;
import com.almutarreb.hamodpos.model.PRODUCT;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyViewHolder> implements Filterable {
    private Context context;
    ArrayList products;
    ArrayList<PRODUCT> AllProducts;
      ;
    private Activity activity;
    public RecyclerView_Adapter(Activity activity, Context context, ArrayList products)
    {
        this.context=context;
        this.products=products;
        this.AllProducts=new ArrayList(products);

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
    PRODUCT product= (PRODUCT) products.get(position);
       holder.product_name.setText(String.valueOf(product.product_name));
        holder.quantity.setText(String.valueOf(product.quantity));
        holder.price.setText(String.valueOf(product.price));

    }
PRODUCT getProduct(){

        PRODUCT p =new PRODUCT();
        return  p;
}



    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
Filter filter=new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        List<PRODUCT> filter_list= new ArrayList<>();
        if(constraint.toString().isEmpty())
        {
filter_list.addAll(AllProducts);
        }
        else
        {
            for (PRODUCT key : AllProducts)
            {
                if(key.getProduct_name().toLowerCase().contains(constraint.toString().toLowerCase()))
                {
                    filter_list.add(key);
                }
            }
        }
        FilterResults filterResults= new FilterResults();
        filterResults.values=filter_list;

        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
products.clear();
products.addAll((Collection) results.values);
notifyDataSetChanged();
    }
};
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
