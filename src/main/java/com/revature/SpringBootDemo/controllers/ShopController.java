package com.revature.SpringBootDemo.controllers;

import static com.revature.SpringBootDemo.utils.ClientMessageUtils.*;
import com.revature.SpringBootDemo.models.ClientMessage;
import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Allows application to stay RESTful with the addition of the same "base" URL
@RestController
@RequestMapping("/app")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping(value = "/shop", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Shop getByID(@RequestParam int id) {
        return shopService.getShopByID(id);
    }

    @GetMapping ("/shops")
    public @ResponseBody List<Shop> getAll() {
        return shopService.getAllShops();
    }

    @PostMapping("/shop")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createShop(@RequestBody Shop shop) {
        return shopService.createShop(shop) ? CREATION_SUCCESSFUL: CREATION_FAILED;
    }

    @PutMapping("/shop")
    public @ResponseBody ClientMessage updateShop(@RequestBody Shop shop) {
        return shopService.updateShop(shop) ? UPDATE_SUCCESSFUL: UPDATE_FAILED;
    }

    @DeleteMapping("/shop")
    public @ResponseBody ClientMessage deleteShop(@RequestBody Shop shop) {
        return shopService.deleteShop(shop) ? DELETION_SUCCESSFUL: DELETION_FAILED;
    }
}