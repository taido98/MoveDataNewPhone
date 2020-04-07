package com.example.getimage;

public class Data {
    private String mTypeData;
    private int mUrlData;
    private int mSize;
    public Data(String typeData, int urlData, int size){
        this.mTypeData = typeData;
        this.mUrlData = urlData;
        this.mSize = size;
    }

    public String getTypeData() {
        return mTypeData;
    }

    public void setTypeData(String mTypeData) {
        this.mTypeData = mTypeData;
    }

    public int getUrlData() {
        return mUrlData;
    }

    public void setUrlData(int mUrlData) {
        this.mUrlData = mUrlData;
    }

    public int getSize() {
        return mSize;
    }

    public void setSize(int mSize) {
        this.mSize = mSize;
    }
}
