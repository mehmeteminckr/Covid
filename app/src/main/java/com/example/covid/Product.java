package com.example.covid;

import java.util.ArrayList;
public class Product {
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private String itemName;
    private String itemDescription;
    private int imageId;

    public Product(){

    }
    public Product(int imageId,String itemName,String itemDescription){
        this.imageId=imageId;
        this.itemName=itemName;
        this.itemDescription=itemDescription;

    }
    public ArrayList<Product> getData(){
        ArrayList<Product> itemList = new ArrayList<Product>();
        int itemImages[] = {R.drawable.sondakika, R.drawable.vakasayisi, R.drawable.korunma};
        String [] itemNames = {"Son Dakika Haberleri","Vaka Sayısı","Nasıl Korunulur ?"};
        String [] itemDescriptions = {"Son dakika haberlerini öğrenin","Güncel vaka sayısı","Virüsten nasıl korunuruz"};

        for (int i = 0; i < itemImages.length; i++) {
            Product temp = new Product();
            temp.setImageId(itemImages[i]);
            temp.setItemName(itemNames[i]);
            temp.setItemDescription(itemDescriptions[i]);

            itemList.add(temp);

        }
        return itemList;
    }

}
