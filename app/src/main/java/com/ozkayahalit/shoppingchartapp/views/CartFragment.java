package com.ozkayahalit.shoppingchartapp.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.ozkayahalit.shoppingchartapp.adapters.CartListAdapter;
import com.ozkayahalit.shoppingchartapp.databinding.FragmentCartBinding;
import com.ozkayahalit.shoppingchartapp.models.CartItem;
import com.ozkayahalit.shoppingchartapp.viewmodels.ShopViewModel;

import java.util.List;

public class CartFragment extends Fragment {
    private static final String TAG = "CartFragment";
    ShopViewModel shopViewModel;
    FragmentCartBinding fragmentCartBinding;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding = FragmentCartBinding.inflate(inflater, container, false);
        return fragmentCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CartListAdapter cartListAdapter = new CartListAdapter();

        fragmentCartBinding.cartRecyclerView.setAdapter(cartListAdapter);
        fragmentCartBinding.cartRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL));

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                cartListAdapter.submitList(cartItems);

            }
        });
    }
}