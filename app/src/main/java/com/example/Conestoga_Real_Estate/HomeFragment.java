package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {
    private Button mShowProp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        mShowProp = (Button)v.findViewById(R.id.showProp);

        mShowProp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View pa) {

                Intent pActivity = new Intent(getActivity(), PropertyActivity.class);
                startActivity(pActivity);

            };

        });


        return v;
    }
}

