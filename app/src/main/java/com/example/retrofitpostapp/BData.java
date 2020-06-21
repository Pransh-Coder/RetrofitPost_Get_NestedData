package com.example.retrofitpostapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BData {

    @SerializedName("Model")
    @Expose
    private String model;

    @SerializedName("Data")
    @Expose
    private List<Data> dataList;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
