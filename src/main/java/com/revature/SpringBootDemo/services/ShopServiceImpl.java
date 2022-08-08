package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.repos.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepo shRepo;

    @Autowired
    public ShopServiceImpl(ShopRepo shRepo) {
        this.shRepo = shRepo;
    }

    @Override
    public boolean createShop(Shop shop) {
        int pk = shRepo.save(shop).getId();
        return (pk > 0) ? true: false;
    }

    @Override
    public Shop getShopByID(int id) {
        try {
            Optional<Shop> target = shRepo.findById(id);
            Shop shop = target.get();
            return shop;
        } catch (NoSuchElementException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Shop> getAllShops() {
        return shRepo.findAll();
    }

    @Override
    public boolean updateShop(Shop shop) {
        return shRepo.update(shop.getShopName(), shop.getInvCount(), shop.getId());
    }

    @Override
    public boolean deleteShop(Shop shop) {
        shRepo.delete(shop);
        return true;
    }

    public void doCors(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin","http://127.0.0.1:5500");
        resp.addHeader("Vary","Origin");
        resp.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, PUT, DELETE, HEAD");
        resp.addHeader("Access-Control-Allow-Headers","*");
        //resp.addHeader("Access-Control-Allow-Headers","X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        resp.addHeader("Access-Control-Allow-Credentials","true");
        resp.addHeader("Access-Control-Max-Age","1728000");
        resp.addHeader("Produces","application/json");

    }
}