package com.tim.project.controller;


import com.tim.project.model.Shop;
import com.tim.project.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Shop> getAllShop() {

        return shopService.getAllShops();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Shop getShopById(@PathVariable("id") int id) {
        return shopService.getShopById(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public List<Shop> getShopByName(@RequestParam String name) {
        return shopService.getShopByName(name);
    }
    @RequestMapping(method = RequestMethod.GET, params = {"type"})
    public List<Shop> getShopByType(@RequestParam String type) {
        return shopService.getShopByName(type);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateShop(@RequestBody Shop shop) {
        shopService.updateShop(shop);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteShopById(@PathVariable("id") int id) {
        shopService.deleteShop(id);
    }
}