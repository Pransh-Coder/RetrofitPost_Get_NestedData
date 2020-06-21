package com.example.retrofitpostapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categories {

    @SerializedName("Brand")
    @Expose
    private String brand;

    @SerializedName("Image")
    @Expose
    private String image;

    @SerializedName("BData")
    @Expose
    private List<BData> bDataList;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<BData> getbDataList() {
        return bDataList;
    }

    public void setbDataList(List<BData> bDataList) {
        this.bDataList = bDataList;
    }
}
