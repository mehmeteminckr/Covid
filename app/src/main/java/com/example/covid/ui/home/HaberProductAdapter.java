package com.example.covid.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.covid.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;

public class HaberProductAdapter extends RecyclerView.Adapter<HaberProductAdapter.MyViewHolder> {
    ArrayList<HaberProduct> mProductList;
    LayoutInflater inflater;
    Context context;
    private WebView webView;

    public HaberProductAdapter(Context context, ArrayList<HaberProduct> products){
        //this.inflater=LayoutInflater.from(context);
        this.mProductList=products;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.haberler_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HaberProductAdapter.MyViewHolder holder, int position) {
        HaberProduct selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);
        Picasso.with(context).load(selectedProduct.getImageId()).resize(120, 60).into(holder.productImage);
    }


    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName, productDescription;
        ImageView productImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.title);
            productDescription = (TextView) itemView.findViewById(R.id.description);
            productImage = (ImageView) itemView.findViewById(R.id.urlToImage);
        }

        public void setData(HaberProduct selectedProduct, int position) {

            this.productName.setText(selectedProduct.getItemName());
            this.productDescription.setText(selectedProduct.getItemDescription());
            //this.productImage.setImageResource(selectedProduct.getImageId());
            productDescription.setOnClickListener(this);

        }


        @SuppressLint("SetJavaScriptEnabled")
        @Override
        public void onClick(View v) {
            HaberProduct product=mProductList.get(getAdapterPosition());
            ArrayList itemList = null;
            try {
                itemList = product.getData();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            HaberProduct temp = (HaberProduct) itemList.get(getAdapterPosition());
            Bundle bundle=new Bundle();
            bundle.putString("url",temp.getHaberUrl());
            Navigation.findNavController(v).navigate(R.id.action_haberler_to_tekbirhaber2,bundle);
        }

    }


}
