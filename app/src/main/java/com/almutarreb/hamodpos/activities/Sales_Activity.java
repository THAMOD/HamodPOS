package com.almutarreb.hamodpos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
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
ArrayList<PRODUCT> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_);

        storeDataInArrays();
        recyclerView=findViewById(R.id.recycler_items);
        recyclerView_adapter=new RecyclerView_Adapter(Sales_Activity.this,getApplicationContext(),products);
        recyclerView.setAdapter(recyclerView_adapter);

    }
    void storeDataInArrays(){
        MyDataBaseHelper db= new MyDataBaseHelper(getApplicationContext());
        Cursor cursor = db.readAllData();
        products=new ArrayList<PRODUCT>();
       // Toast.makeText(this, "data in the cursue", Toast.LENGTH_SHORT).show();
        try {
            if(cursor.getCount() == 0){
            }else{

                while (cursor.moveToNext()){
                    products.add(new PRODUCT (cursor.getString(1),
                            Integer.valueOf(cursor.getString(2)),
                            Float.valueOf(cursor.getString(3))));
                    Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                }

            }

        }catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
      //
    }
}