package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.models.Shop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ShopService {

    // Creates a new Candy
    boolean createShop(Shop shop);

    // Get a Candy
    Shop getShopByID(int id);

    // Get ALL Candies
    List<Shop> getAllShops();

    // Update a Candy
    boolean updateShop(Shop shop);

    // Delete a Candy
    boolean deleteShop(Shop shop);

    void doCors(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
