package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SaleActivity extends AppCompatActivity  implements RecycleAdapter.OnViewListener{
    private ArrayList<Property> mProperty, mPropertySale;
    boolean mFlag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);


        mPropertySale = SalePropList.getInstance().getProperty();

        mProperty = PropertyList.getInstance().getProperty();
        Log.i("mproperty",mProperty.toString());

        for(int i=0;i<mProperty.size();i++) {

            if (mProperty.get(i).gettype() == "Sale"){

                for (Property property : mPropertySale) {

                    if(property.getPropName() == mProperty.get(i).getPropName()){

                        mFlag = true;
                    }
                }

                if(mFlag == false){

                    Property tempProp = new Property(mProperty.get(i).getPropName(),
                            mProperty.get(i).getPropAdd(),
                            mProperty.get(i).getBedroom(),
                            mProperty.get(i).getFurnished(),
                            mProperty.get(i).getSize(),
                            mProperty.get(i).getBathroom(),
                            mProperty.get(i).getPropDetail(),
                            mProperty.get(i).getPropDate(),
                            mProperty.get(i).getPrice(),
                            mProperty.get(i).getImg(),
                            mProperty.get(i).getImg(),
                            mProperty.get(i).gettype());

                    mPropertySale.add(tempProp);

                }

            }

        }


        Log.i("mpropertyRent",mPropertySale.toString());

        RecyclerView recyclerView=findViewById(R.id.propview);
        RecycleAdapter adapter = new RecycleAdapter(getApplicationContext(),mPropertySale,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onViewClick(int position) {
        mPropertySale.get(position);
        Intent i = new Intent(getApplicationContext(), DisplayActivity.class);
        i.putExtra("Position", position);
        i.putExtra("classtype", "sale");
        startActivity(i);

    }



}

