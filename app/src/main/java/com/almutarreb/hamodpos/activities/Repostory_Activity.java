package com.almutarreb.hamodpos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.almutarreb.hamodpos.R;
import com.almutarreb.hamodpos.data.MyDataBaseHelper;
import com.almutarreb.hamodpos.model.PRODUCT;

public class Repostory_Activity extends AppCompatActivity {
EditText txt_product_name ,txt_quantity,txt_price;
Button btn_add,btn_showall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repostory_);
        txt_product_name=findViewById(R.id.txt_product_name);
        txt_quantity=findViewById(R.id.txt_quantity);
        txt_price=findViewById(R.id.txt_price);
        btn_add=findViewById(R.id.btn_add);
        btn_showall=findViewById(R.id.btn_show_all);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PRODUCT p = new PRODUCT(txt_product_name.getText().toString().trim(),
                      Integer.valueOf(  txt_quantity.getText().toString().trim()),
                        Float.valueOf(txt_price.getText().toString().trim()));
                MyDataBaseHelper db=new MyDataBaseHelper(Repostory_Activity.this);
                db.add_product(p);
            }
        });
        btn_showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Repostory_Activity.this,ShowAllProducts_Activity.class));
            }
        });
    }
}