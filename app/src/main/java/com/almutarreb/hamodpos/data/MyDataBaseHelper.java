package com.almutarreb.hamodpos.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.almutarreb.hamodpos.model.PRODUCT;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME="STORE.db";
    private Context context;
    private final static int DATABASE_VERSION=1;

    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Table_users_query="CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                "uesrname  TEXT UNIQUE," +
                "password TEXT NOT NULL ," +
                "email TETX NOT NULL UNIQUE)";
        String Table_products_querey="CREATE TABLE products (id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "product_name TEXT UNIQUE ," +
                "quantity INTEGER NOT NULL ," +
                "price REAL NOT NULL  );";
        db.execSQL(Table_users_query);
        db.execSQL(Table_products_querey);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS  users" );
        db.execSQL("DROP TABLE IF EXISTS  products" );
        onCreate(db);
    }
    public void add_product(PRODUCT p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("product_name", p.getProduct_name());
        cv.put("quantity", p.getQuantity());
        cv.put("price", p.getPrice());
        long result = db.insert("products",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor readAllData(){
        String query = "SELECT * FROM products " ;
        Cursor cursor = null;
        try
        {
            SQLiteDatabase db = this.getReadableDatabase();

            if(db != null){
                cursor = db.rawQuery(query, null,null);
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(context, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

        return cursor;
    }
}
