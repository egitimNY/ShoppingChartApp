package com.ozkayahalit.shoppingchartapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ozkayahalit.shoppingchartapp.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(),"GENERAL MOBİLE", 550, true,"https://ozkayahalit.com/shopmvvm/demo_pets/pets_picture/19.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"XIAOMI REDMI", 750, true,"https://ozkayahalit.com/shopmvvm/demo_pets/pets_picture/18.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"LENOVO IDEAPAD", 625, false,"https://ozkayahalit.com/shopmvvm/demo_pets/pets_picture/17.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"LG", 800, true,"https://ozkayahalit.com/shopmvvm/demo_pets/pets_picture/15.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"ALCATEL", 450, true,"https://ozkayahalit.com/shopmvvm/demo_pets/pets_picture/20.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"Ipad", 1200, true,"https://ozkayahalit.com/shopmvvm/demo_pets/pets_picture/12.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"SAMSUNG", 900, true,"https://ozkayahalit.com/shopmvvm/demo_pets/pets_picture/13.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"Kingston 480GB HyperX Fury 3D", 150, false,"https://ozkayahalit.com/shopmvvm/demo_pets/pets_picture/14.jpeg"));

        mutableProductList.setValue(productList);
    }
}
