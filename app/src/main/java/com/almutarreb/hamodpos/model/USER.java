package com.almutarreb.hamodpos.model;

public class USER {
    private  int id;
    private String username ;
    private  String password;
    private  String email;
    USER(String username,String password,String email)
    {
        this.username=username;
        this.password=password;
        this.email=email;
    }
     int get_id()
    {
        return id;
    }



}
