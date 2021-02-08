package com.example.Conestoga_Real_Estate;

import java.util.ArrayList;

public class SalePropList {

    private static final SalePropList ourInstance = new SalePropList();

    private ArrayList<Property> mrecentview;

    public static SalePropList getInstance() {

        return ourInstance;

    }

    private SalePropList() {

        mrecentview = new ArrayList<Property>();

    }

    public ArrayList<Property> getProperty(){

        return mrecentview;

    }

}
