package com.example.covid.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.ImageView;

import com.example.covid.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class HaberProduct {
    public String getItemName() {
        return itemTitle;
    }

    public void setItemName(String itemName) {
        this.itemTitle = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getImageId() {
        return imageUrl;
    }

    public void setImageId(String imageId) {
        this.imageUrl = imageId;
    }

    public String getHaberUrl() {
        return haberUrl;
    }

    public void setHaberUrl(String haberUrl) {
        this.haberUrl = haberUrl;
    }

    private String itemTitle;
    private String itemDescription;
    private String imageUrl;
    private String haberUrl;

    public HaberProduct(){

    }
    public HaberProduct(String imageId,String itemName,String itemDescription){
        this.imageUrl=imageId;
        this.itemTitle=itemName;
        this.itemDescription=itemDescription;

    }
    public ArrayList<HaberProduct> getData() throws JSONException {
        ArrayList<HaberProduct> itemList = new ArrayList<HaberProduct>();
        int itemImages[] = {};
        String [] itemNames = {};
        String [] itemDescriptions = {};

        for (int i = 0; i < 10; i++) {
            HaberProduct temp = new HaberProduct();
            JSONObject jsonObject = new JSONObject(HaberlerViewModel.mText.getValue().getString(i));

            temp.setImageId(jsonObject.getString("urlToImage"));
            temp.setItemName(jsonObject.getString("title"));
            temp.setItemDescription(jsonObject.getString("description"));
            temp.setHaberUrl(jsonObject.getString("url"));
            itemList.add(temp);

        }
        return itemList;
    }


}
