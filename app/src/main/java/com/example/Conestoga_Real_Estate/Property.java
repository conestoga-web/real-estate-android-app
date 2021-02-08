package com.example.Conestoga_Real_Estate;

import java.io.Serializable;

public class Property implements Serializable {

    private String mPropName;
    private String mPropAdd;
    private String mBedroom;
    private String mFurnished;
    private String mSize;
    private Integer mBathroom;
    private String mPropDetail;
    private String mPropDate;
    private String mPrice;
    private String mimg;
    private String msimg;
    private String mtype;

    public Property(String propName, String propAdd, String bedroom, String furnished, String size, Integer bathroom, String propDetail, String propDate, String price, String img, String simg, String type){

        mPropName = propName;
        mPropAdd = propAdd;
        mBedroom = bedroom;
        mFurnished = furnished;
        mSize = size;
        mBathroom = bathroom;
        mPropDetail = propDetail;
        mPropDate = propDate;
        mPrice = price;
        mimg = img;
        msimg = simg;
        mtype = type;

    }

    public String getPropName() {
        return mPropName;
    }

    public String getPropAdd() {
        return mPropAdd;
    }

    public String getBedroom() {
        return mBedroom;
    }

    public String getFurnished() {
        return mFurnished;
    }

    public String getSize() {
        return mSize;
    }

    public Integer getBathroom() {
        return mBathroom;
    }

    public String getPropDetail() {
        return mPropDetail;
    }

    public String getPropDate() {
        return mPropDate;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getImg() {
        return mimg;
    }

    public String geticonImg() {
        return msimg;
    }

    public String gettype() {
        return mtype;
    }

}
