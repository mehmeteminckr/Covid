package com.example.covid.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.covid.ProductAdapter;
import com.example.covid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class haberler extends Fragment {
    RecyclerView recyclerView;
    HaberProduct product;

    public haberler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_haberler, container, false);
        HaberlerViewModel viewModel=new ViewModelProvider(requireActivity()).get(HaberlerViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<JSONArray>() {
            @Override
            public void onChanged(JSONArray jsonArray) {
                recyclerView=(RecyclerView) view.findViewById(R.id.recylerview_haberler);
                product = new HaberProduct();
                HaberProductAdapter productAdapter = null;
                try {
                    productAdapter = new HaberProductAdapter(getActivity(), product.getData());
                } catch (JSONException e) {
                    Log.d("product","heyyoooo");
                    e.printStackTrace();
                }
                recyclerView.setAdapter(productAdapter);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });

        return view;
    }

}
