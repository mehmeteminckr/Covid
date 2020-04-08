package com.example.covid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    ArrayList<Product> mProductList;
    LayoutInflater inflater;
    Context context;

    public ProductAdapter(Context context, ArrayList<Product> products){
        //this.inflater=LayoutInflater.from(context);
        this.mProductList=products;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);

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
            productName = (TextView) itemView.findViewById(R.id.baslik);
            productDescription = (TextView) itemView.findViewById(R.id.description);
            productImage = (ImageView) itemView.findViewById(R.id.imageView);
        }

        public void setData(Product selectedProduct, int position) {

            this.productName.setText(selectedProduct.getItemName());
            this.productDescription.setText(selectedProduct.getItemDescription());
            this.productImage.setImageResource(selectedProduct.getImageId());
            productDescription.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            Product product=mProductList.get(getAdapterPosition());
            switch (product.getItemName()){
                case "Son Dakika Haberleri":
                    Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_haberler);
                    break;
                case "Vaka Sayısı":
                    Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_vakasyisi);
                    break;
                case "Nasıl Korunulur ?":
                    Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_korunma);
                    break;
            }

            }

        }


    }
