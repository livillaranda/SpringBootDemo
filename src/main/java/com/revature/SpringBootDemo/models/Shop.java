package com.revature.SpringBootDemo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int id;

    @Column(name = "s_name", unique = true, nullable = false)
    private String shopName;

    @Column(name = "s_inv_count", nullable = false)
    private int invCount;

    public Shop() {
    }

    public Shop(int id, String shopName, int invCount) {
        this.id = id;
        this.shopName = shopName;
        this.invCount = invCount;
    }

    public Shop(String shopName, int invCount) {
        this.shopName = shopName;
        this.invCount = invCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getInvCount() {
        return invCount;
    }

    public void setInvCount(int invCount) {
        this.invCount = invCount;
    }
}