package com.example.covid.ui.notifications;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;

public class ProfilProductAdapter extends RecyclerView.Adapter<ProfilProductAdapter.MyViewHolder> {
    ArrayList<ProfilProduct> mProductList;
    LayoutInflater inflater;
    Context context;
    private WebView webView;


    public ProfilProductAdapter(Context context, ArrayList<ProfilProduct> products){
        this.mProductList=products;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profil_loyut, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProfilProduct selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);
        //Picasso.with(context).load(selectedProduct.getImageId()).resize(120, 60).into(holder.productImage);
    }



    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView  productDescription;
        ImageView productImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            productDescription = (TextView) itemView.findViewById(R.id.description_profil);
            productImage = (ImageView) itemView.findViewById(R.id.imageView_profil);
        }

        public void setData(ProfilProduct selectedProduct, int position) {

            this.productDescription.setText(selectedProduct.getItemDescription());
            this.productImage.setImageResource(selectedProduct.getImageId());


        }

        @Override
        public void onClick(View v) {

        }
    }


}
