package com.example.Conestoga_Real_Estate;

import java.util.ArrayList;

public class RecentPropList {

    private static final RecentPropList ourInstance = new RecentPropList();

    private ArrayList<Property> mrecentview;

    public static RecentPropList getInstance() {

        return ourInstance;

    }

    private RecentPropList() {

        mrecentview = new ArrayList<Property>();

    }

    public ArrayList<Property> getProperty(){

        return mrecentview;

    }

}
