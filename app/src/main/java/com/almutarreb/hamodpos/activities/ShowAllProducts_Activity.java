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

public class ShowAllProducts_Activity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView_Adapter adapter;
MyDataBaseHelper db;
ArrayList<PRODUCT> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_products_);
        recyclerView=findViewById(R.id.all_item_recycler);
        list=new ArrayList<PRODUCT>();
        getdata();
        adapter=new RecyclerView_Adapter(ShowAllProducts_Activity.this,getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
    }
    void getdata()
    {
        MyDataBaseHelper db= new MyDataBaseHelper(getApplicationContext());
        Cursor cursor = db.readAllData();
        list=new ArrayList<PRODUCT>();
        // Toast.makeText(this, "data in the cursue", Toast.LENGTH_SHORT).show();
        try {
            if(cursor.getCount() == 0){
            }else{

                while (cursor.moveToNext()){
                    list.add(new PRODUCT (cursor.getString(1),
                            Integer.valueOf(cursor.getString(2)),
                            Float.valueOf(cursor.getString(3))));
                    Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
                }

            }

        }catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}