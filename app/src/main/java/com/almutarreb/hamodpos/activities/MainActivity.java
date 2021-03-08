package com.almutarreb.hamodpos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.almutarreb.hamodpos.adapters.MyCustumAdapter;
import com.almutarreb.hamodpos.R;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
final String[] column_text={"Sales","Purchasing","Custmers","Supplyers","treasury","Expenditury","pruducts","Reports"};
final int []column_image={R.drawable.store_icon,R.drawable.sales_icon,R.drawable.custmers_icon,
R.drawable.supplyers_icon,R.drawable.treasury_icon,R.drawable.expendture_icon,
        R.drawable.repostory_icon,R.drawable.report_icon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);
        gridView.setAdapter(new MyCustumAdapter(getApplicationContext(),column_text,column_image));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (column_text[position])
               {
                   case "pruducts": startActivity(new Intent(MainActivity.this,Repostory_Activity.class));break;
                   case  "Sales" : startActivity(new Intent(MainActivity.this,Sales_Activity.class));
               }
            }
        });

    }
}