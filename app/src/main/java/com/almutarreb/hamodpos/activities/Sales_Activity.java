package com.almutarreb.hamodpos.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.almutarreb.hamodpos.R;
import com.almutarreb.hamodpos.adapters.ListAdapter;
import com.almutarreb.hamodpos.adapters.RecyclerView_Adapter;
import com.almutarreb.hamodpos.data.MyDataBaseHelper;
import com.almutarreb.hamodpos.model.PRODUCT;

import java.util.ArrayList;

public class Sales_Activity extends AppCompatActivity {
    MyDataBaseHelper db;
    RecyclerView recyclerView;
    RecyclerView_Adapter recyclerView_adapter;
    ListView requst_list;
    TextView txt_total;
    ArrayList<PRODUCT> arrayList_product;
    ArrayList products;
    SearchView searchView;
    Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_);
        txt_total = (TextView) findViewById(R.id.txt_total);
        products = new ArrayList<PRODUCT>();
        arrayList_product = new ArrayList<PRODUCT>();
        requst_list = findViewById(R.id.request_list);
        ListAdapter adapter = new ListAdapter(getApplicationContext(), arrayList_product);
        requst_list.setAdapter(adapter);
        storeDataInArrays();
        recyclerView = findViewById(R.id.recycler_items);
        recyclerView_adapter = new RecyclerView_Adapter(Sales_Activity.this, getApplicationContext(), products, requst_list, txt_total);
        recyclerView.setAdapter(recyclerView_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(Sales_Activity.this, 2));
        searchView = findViewById(R.id.sales_txt_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerView_adapter.getFilter().filter(newText);
                return false;
            }
        });
        btn_pay = findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paymentdialog dialog = new Paymentdialog();
                dialog.show(getSupportFragmentManager(), "paydialog");

            }
        });
    }
    void storeDataInArrays(){
         db= new MyDataBaseHelper(getApplicationContext());
        Cursor cursor = db.readAllData();
       // Toast.makeText(this, "data in the cursue", Toast.LENGTH_SHORT).show();
        try {
            if(cursor.getCount() == 0){
            }else{
                while (cursor.moveToNext()){
                    products.add(new PRODUCT(cursor.getString(1),
                    Integer.valueOf(cursor.getString(2)),
                   Float.valueOf (cursor.getString(3))));

                }


            }

        }catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
      //
    }
}