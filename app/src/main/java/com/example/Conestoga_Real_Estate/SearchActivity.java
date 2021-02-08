package com.example.Conestoga_Real_Estate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity{

    ListView mpropList;
    private ArrayList<Property> mProperty;
    LayoutInflater minflter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mProperty = PropertyList.getInstance().getProperty();
        mpropList = (ListView) findViewById(R.id.prodListView);

        //Adapter to load the property list on customAdapter

        // final CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), propName, mpropImg, propAdd, propPrice);
        final PropertyListAdapter customAdapter = new PropertyListAdapter(getApplicationContext(), mProperty);

        mpropList.setAdapter(customAdapter);

        // Activity on List View item click after finding the position of that item

        mpropList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int whichItem, long id) {

                System.out.println("This is the list item click ------------ id-----"+whichItem);
                Intent i = new Intent(getApplicationContext(), DisplayActivity.class);
                i.putExtra("Position", whichItem);
                startActivity(i);

            }


        });

    }
//Property list adapter to generate the view of list item and pass that to product activity

    private class PropertyListAdapter extends ArrayAdapter<Property> {

        public PropertyListAdapter (Context applicationContext, ArrayList<Property> propertylistes){
            super(SearchActivity.this, R.layout.activity_listiew, propertylistes);
            minflter = (LayoutInflater.from(applicationContext));
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup){

            if(view == null){
                view = minflter.inflate(R.layout.activity_listiew, null);
            }

            Property tempproperty = getItem(whichItem);

            TextView name = (TextView)view.findViewById(R.id.txtName);
            TextView address = (TextView)view.findViewById(R.id.txtAdd);
            TextView price = (TextView)view.findViewById(R.id.txtPrice);
            ImageView icon = (ImageView)view.findViewById(R.id.icon);

            name.setText(tempproperty.getPropName());
            address.setText(tempproperty.getPropAdd());
            price.setText(tempproperty.getPrice());

            int imageResource = getResources().getIdentifier(tempproperty.geticonImg(),null, SearchActivity.this.getPackageName());
            icon.setImageResource(imageResource);

            System.out.println("------------------------------------"+imageResource);
            return view;
        }

    }


}
