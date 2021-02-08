package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RentActivity extends AppCompatActivity implements RecycleAdapter.OnViewListener{
    private ArrayList<Property> mProperty, mPropertyRate;
    boolean mFlag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        mPropertyRate=RentPropList.getInstance().getProperty();

        mProperty = PropertyList.getInstance().getProperty();
        Log.i("mproperty",mProperty.toString());

        for(int i=0;i<mProperty.size();i++) {

            if (mProperty.get(i).gettype() == "Rent"){

                for (Property property : mPropertyRate) {

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

                    mPropertyRate.add(tempProp);

                }

            }

        }

        Log.i("mpropertyRent",mPropertyRate.toString());

        RecyclerView recyclerView=findViewById(R.id.propview);
        RecycleAdapter adapter = new RecycleAdapter(getApplicationContext(),mPropertyRate,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onViewClick(int position) {
        mPropertyRate.get(position);
        Intent i = new Intent(getApplicationContext(), DisplayActivity.class);
        i.putExtra("Position",position);
        i.putExtra("classtype", "rent");
        startActivity(i);

    }
    }


