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
        productList.add(new Product(UUID.randomUUID().toString(),"iPhone 21", 1299, true,"https://ozkayahalit.com/Haerul/demo_pets/pets_picture/19.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"MacBook 1", 15, false,"https://ozkayahalit.com/Haerul/demo_pets/pets_picture/18.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"Windows 10 21", 45, true,"https://ozkayahalit.com/Haerul/demo_pets/pets_picture/17.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"Computer 21", 5, false,"https://ozkayahalit.com/Haerul/demo_pets/pets_picture/15.jpeg"));

        productList.add(new Product(UUID.randomUUID().toString(),"Camera 21", 1299, true,"https://ozkayahalit.com/Haerul/demo_pets/pets_picture/19.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"Light 1", 15, false,"https://ozkayahalit.com/Haerul/demo_pets/pets_picture/18.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"Jacket 21", 45, true,"https://ozkayahalit.com/Haerul/demo_pets/pets_picture/17.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(),"T-Shirt 21", 5, false,"https://ozkayahalit.com/Haerul/demo_pets/pets_picture/15.jpeg"));
        mutableProductList.setValue(productList);
    }
}
