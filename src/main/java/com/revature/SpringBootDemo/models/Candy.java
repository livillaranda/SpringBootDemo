package com.revature.SpringBootDemo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "candies")
@Data
public class Candy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private int id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_price", nullable = false)
    private Double price;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "c_shop", referencedColumnName = "s_id")
    private Shop shop;

    public Candy() {
    }

    public Candy(int id, String name, Double price, Shop shop) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

    public Candy(String name, Double price, Shop shop) {
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}