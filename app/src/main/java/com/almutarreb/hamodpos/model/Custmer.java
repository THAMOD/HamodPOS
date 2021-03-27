package com.almutarreb.hamodpos.model;

public class Custmer {
    int id;
    String name;
    String phone;
    float amount_due;

    public Custmer(String name, String phone, float amount_due) {
        this.name = name;
        this.phone = phone;
        this.amount_due = amount_due;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public float getAmount_due() {
        return amount_due;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount_due(float amount_due) {
        this.amount_due = amount_due;
    }
}
