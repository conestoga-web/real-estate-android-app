package com.example.Conestoga_Real_Estate;

import java.util.ArrayList;

public class RentPropList {

    private static final RentPropList ourInstance = new RentPropList();

    private ArrayList<Property> mrecentview;

    public static RentPropList getInstance() {

        return ourInstance;

    }

    private RentPropList() {

        mrecentview = new ArrayList<Property>();

    }

    public ArrayList<Property> getProperty(){

        return mrecentview;

    }

}
