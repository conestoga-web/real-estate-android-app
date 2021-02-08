package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PropertyActivity extends AppCompatActivity implements RecycleAdapter.OnViewListener {

    private ArrayList<Property> mProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        mProperty = PropertyList.getInstance().getProperty();

        //Window w = getWindow();
        //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView = findViewById(R.id.propview);

        RecycleAdapter adapter = new RecycleAdapter(getApplicationContext(), mProperty, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onViewClick(int position) {
        mProperty.get(position);
        Intent i = new Intent(getApplicationContext(), DisplayActivity.class);
        i.putExtra("Position", position);
        i.putExtra("classtype", "");
        startActivity(i);

    }
}
