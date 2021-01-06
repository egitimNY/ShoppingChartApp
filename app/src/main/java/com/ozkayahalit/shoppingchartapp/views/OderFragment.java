package com.ozkayahalit.shoppingchartapp.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ozkayahalit.shoppingchartapp.R;
import com.ozkayahalit.shoppingchartapp.databinding.FragmentOderBinding;
import com.ozkayahalit.shoppingchartapp.viewmodels.ShopViewModel;

public class OderFragment extends Fragment {

    NavController navController;
    FragmentOderBinding fragmentOderBinding;
    ShopViewModel shopViewModel;

    public OderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_oder, container, false);
         fragmentOderBinding = FragmentOderBinding.inflate(inflater,
                container, false);
        return fragmentOderBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);

        fragmentOderBinding.continueShoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shopViewModel.resetCart();
                navController.navigate(R.id.action_oderFragment_to_shopFragment);
            }
        });
    }
}