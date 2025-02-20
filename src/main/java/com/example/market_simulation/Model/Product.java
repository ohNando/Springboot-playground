package com.example.market_simulation.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;

    public Product() {}

    public Product(long id,String name,float price,int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Getter and setter functions
    public long getId() { return id; }
    public void setId(long id) {this.id = id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public float getPrice(){ return price; }
    public void setPrice(float price){ this.price = price; }

    public int getQuantity(){ return quantity; }
    public void setQuantity(int quantity){ this.quantity = quantity; }
}
