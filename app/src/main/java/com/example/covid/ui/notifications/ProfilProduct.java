package com.example.covid.ui.notifications;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.ImageView;

import com.example.covid.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class ProfilProduct {
    FirebaseUser firebaseUser;

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getImageId() {
        return imageUrl;
    }

    public void setImageId(int imageId) {
        this.imageUrl = imageId;
    }




    private String itemDescription;
    private int imageUrl;

    public ProfilProduct(){
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    }
    public ProfilProduct(int imageId, String itemDescription){
        this.imageUrl=imageId;
        this.itemDescription=itemDescription;

    }
    public ArrayList<ProfilProduct> getData() throws JSONException {
        ArrayList<ProfilProduct> itemList = new ArrayList<ProfilProduct>();
        Map<String,Object> itemDescription = NotificationsViewModel.mText.getValue();

        for (Map.Entry<String,Object> entry:itemDescription.entrySet()) {
            ProfilProduct temp = new ProfilProduct();
            temp.setImageId(R.drawable.corona_virus);
            temp.setItemDescription(entry.getValue().toString());
            itemList.add(temp);
        }
        return itemList;
    }


}
