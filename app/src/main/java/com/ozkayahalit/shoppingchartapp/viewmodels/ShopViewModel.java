package com.ozkayahalit.shoppingchartapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ozkayahalit.shoppingchartapp.models.Product;
import com.ozkayahalit.shoppingchartapp.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProducts(){
        return shopRepo.getProducts();
    }
}
