package com.almutarreb.hamodpos.model;

public class PRODUCT {
   public int id;
   public   String product_name;
     public int quantity;
      public  float price;
      public  PRODUCT()
      {

      }
    public PRODUCT(int id,String product_name, int quantity, float price)
    {
        this.id=id;
        this.product_name=product_name;
        this.price=price;
        this.quantity=quantity;
    }

    public PRODUCT(String product_name, Integer quantity, Float price) {
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
