package com.almutarreb.hamodpos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.almutarreb.hamodpos.R;
import com.almutarreb.hamodpos.adapters.RecyclerView_Adapter;
import com.almutarreb.hamodpos.data.MyDataBaseHelper;
import com.almutarreb.hamodpos.model.PRODUCT;

import java.util.ArrayList;

public class Sales_Activity extends AppCompatActivity {
MyDataBaseHelper db;
RecyclerView recyclerView;
RecyclerView_Adapter recyclerView_adapter;
ArrayList products_name,quantity,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_);
        products_name= new ArrayList<String>();
        quantity=new ArrayList<String>();
        price= new ArrayList<String>();
        storeDataInArrays();
        recyclerView=findViewById(R.id.recycler_items);
        recyclerView_adapter=new RecyclerView_Adapter(Sales_Activity.this,getApplicationContext(),products_name,quantity,price);
        recyclerView.setAdapter(recyclerView_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Sales_Activity.this));


    }
    void storeDataInArrays(){
        MyDataBaseHelper db= new MyDataBaseHelper(getApplicationContext());
        Cursor cursor = db.readAllData();
       // Toast.makeText(this, "data in the cursue", Toast.LENGTH_SHORT).show();
        try {
            if(cursor.getCount() == 0){
            }else{
                while (cursor.moveToNext()){
                    products_name.add(cursor.getString(1));
                    quantity.add(cursor.getString(2));
                    price.add(cursor.getString(3));

                }


            }

        }catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
      //
    }
}