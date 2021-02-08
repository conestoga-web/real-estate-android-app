package com.example.Conestoga_Real_Estate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

// This Class is not in use any more... just here for future reference


    Context context;
    String propName[];
    String propAdd[];
    String propPrice[];
    int propImg[];
    LayoutInflater inflter;
    private ArrayList<Property> mProperty;

    public CustomAdapter(Context applicationContext, String[] name, int[] img, String[] address, String[] price) {
        this.context = context;
        this.propName = name;
        this.propAdd = address;
        this.propPrice = price;
        this.propImg = img;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return propName.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = inflter.inflate(R.layout.activity_listiew, null);
        }

        TextView country = (TextView)view.findViewById(R.id.txtName);
        TextView address = (TextView)view.findViewById(R.id.txtAdd);
        TextView price = (TextView)view.findViewById(R.id.txtPrice);

        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        country.setText(propName[i]);
        address.setText(propAdd[i]);
        price.setText(propPrice[i]);
        icon.setImageResource(propImg[i]);
        return view;
    }

}
