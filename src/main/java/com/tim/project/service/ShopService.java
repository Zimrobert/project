package com.tim.project.service;

import com.tim.project.model.Shop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ShopService {

    private List<Shop>shops;
    public ShopService(){
        shops= new ArrayList(Arrays.asList(
                new Shop(1,"Kaufland","Supermarket","Timisoara"),
                new Shop(2,"Kaufland","Supermarket","Timisoara"),
                new Shop(3,"Kaufland","Supermarket","Timisoara")
        ));
    }
    public List<Shop> getAllShops()
    {return shops;}

    public Shop getShopById(int id){
        List<Shop>shops =getAllShops();
        for (Shop i: shops) {
            if(i.getId()==id){
                return i;
            }
        }
        return new Shop();
    }
    public List<Shop>getShopByName(String name){
        List<Shop>shops=new ArrayList<>();
        for (Shop shop: getAllShops()){
            if(shop.getName().equals(name)){
            shops.add(shop);
        }}
        return shops;
    }
    public void addShop(Shop shop){
        shops.add(shop);
    }
    public Shop updateShop(Shop shop) {
        Shop originalShop = getShopById(shop.getId());
        shops.remove(originalShop);
        originalShop.setId(shop.getId());
        originalShop.setName(shop.getName());
        originalShop.setLocation(shop.getLocation());
        originalShop.setType(shop.getType());
        shops.add(originalShop);
        return originalShop;
    }
    public void deleteShop(int id){
        Shop shop = getShopById(id);
        shops.remove(shop);
    }
}