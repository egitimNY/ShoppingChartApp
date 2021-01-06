package com.ozkayahalit.shoppingchartapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ozkayahalit.shoppingchartapp.models.CartItem;
import com.ozkayahalit.shoppingchartapp.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartRepo {

    private MutableLiveData<List<CartItem>> mutableCart = new MutableLiveData<>();

    public LiveData<List<CartItem>> getCart(){
        if (mutableCart.getValue() == null) {
            initCart();
        }
        return mutableCart;
    }

    private void initCart() {
        mutableCart.setValue(new ArrayList<CartItem>());
    }

    public boolean addItemToCart(Product product) {
        if (mutableCart.getValue() == null) {
            initCart();
        }

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        for (CartItem cartItem: cartItemList) {
            if (cartItem.getProduct().getId().equals(product.getId())) {
                if (cartItem.getQuantity() == 5) {
                    return false;
                }

                int index = cartItemList.indexOf(cartItem);
                cartItem.setQuantity(cartItem.getQuantity() +1);
                cartItemList.set(index, cartItem);

                mutableCart.setValue(cartItemList);

                return true;
            }
        }

        CartItem  cartItem = new CartItem(product,1);
        cartItemList.add(cartItem);
        mutableCart.setValue(cartItemList);
        return true;
    }

    public void removeItemFromCart(CartItem cartItem) {
        if (mutableCart.getValue() == null){
            return;
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        cartItemList.remove(cartItem);
        mutableCart.setValue(cartItemList);
    }

    public void changeQuantity(CartItem cartItem, int quantity){
        if (mutableCart.getValue() == null) return;

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());

        CartItem updatedItem = new CartItem(cartItem.getProduct(), quantity);
        cartItemList.set(cartItemList.indexOf(cartItem), updatedItem);

        mutableCart.setValue(cartItemList);
    }
}
