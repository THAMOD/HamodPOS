package com.almutarreb.hamodpos.model;

public class PRODUCT {
    private int id;
    private  String product_name;
    private  int quantity;
    private float price;
    public PRODUCT(String product_name, int quantity, float price)
    {
        this.product_name=product_name;
        this.price=price;
        this.quantity=quantity;
    }
    public float getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public String getProduct_name()
    {
        return product_name;
    }
    int getId()
    {
        return  id ;
    }
}
