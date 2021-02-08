package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView mtxtPName;
    TextView mtxtPAdd;
    TextView mtxtPBed;
    TextView mtxtPFur;
    TextView mtxtPsize;
    TextView mtxtPbath;
    TextView mtxtPDetail;
    TextView mtxtPDate;
    TextView mtxtPprice;
    ImageView mpropImg;
    Button mbuyNow;
    TextView mtype;
    int mPosition =0;
    String mclasstype;
    public UserCheckout mUser = null;

    boolean mFlag=false;
    private ArrayList<Property> mrecentview;

    //ArrayList<Property> mpropList = new ArrayList<Property>();
    private ArrayList<Property> mProperty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Bundle extras = getIntent().getExtras();

// Get the position of list item using Intent get extra function and displaying value from property array list

        if(extras != null){

            mPosition = extras.getInt("Position");
            mclasstype = extras.getString("classtype");
            System.out.println("------------------------------------Extra Display------------------------------"+mclasstype);
        }

        if( mclasstype.equals("sale")) {

            System.out.println("------------------------------------Sale Display------------------------------"+mclasstype);
            mProperty = SalePropList.getInstance().getProperty();

        }else  if( mclasstype.equals("rent")) {

            System.out.println("------------------------------------Rent Display------------------------------"+mclasstype);
            mProperty = RentPropList.getInstance().getProperty();

        }else  if( mclasstype.equals("recent")) {

            System.out.println("------------------------------------Recent Display------------------------------"+mclasstype);
            mProperty = RecentPropList.getInstance().getProperty();

        }else{

            mProperty = PropertyList.getInstance().getProperty();
            System.out.println("------------------------------------Property Display------------------------------"+mclasstype);

        }

        Property tempproperty = mProperty.get(mPosition);

        mtxtPName = (TextView)findViewById(R.id.propName);
        mtxtPAdd = (TextView)findViewById(R.id.propAdd);
        mtxtPBed = (TextView)findViewById(R.id.bedroom);
        mtxtPFur = (TextView)findViewById(R.id.furnished);
        mtxtPsize = (TextView)findViewById(R.id.size);
        mtxtPbath = (TextView)findViewById(R.id.bathroom);
        mtxtPDetail = (TextView)findViewById(R.id.propDetail);
        mtxtPDate = (TextView)findViewById(R.id.propDate);
        mtxtPprice = (TextView)findViewById(R.id.price);
        mpropImg = (ImageView)findViewById(R.id.propImg);
        mtype = (TextView)findViewById(R.id.proptype);

        mtxtPName.setText(tempproperty.getPropName());
        mtxtPAdd.setText(tempproperty.getPropAdd());
        mtxtPBed.setText(tempproperty.getBedroom());
        mtxtPFur.setText(tempproperty.getFurnished());

        mtxtPsize.setText(tempproperty.getSize());
        mtxtPbath.setText(tempproperty.getBathroom().toString());
        mtxtPDetail.setText(tempproperty.getPropDetail());
        mtxtPDate.setText(tempproperty.getPropDate());
        mtxtPprice.setText(tempproperty.getPrice());
        mtype.setText("For "+tempproperty.gettype());

        setTitle(tempproperty.getPropName());

        mrecentview = RecentPropList.getInstance().getProperty();

        //if(mrecentview.size()>0){

            for (Property property : mrecentview) {

                if(property.getPropName() == tempproperty.getPropName()){

                    mFlag = true;

                }

            }

            if(mFlag == false){

                Property tempProp = new Property(tempproperty.getPropName(),
                        tempproperty.getPropAdd(),
                        tempproperty.getBedroom(),
                        tempproperty.getFurnished(),
                        tempproperty.getSize(),
                        tempproperty.getBathroom(),
                        tempproperty.getPropDetail(),
                        tempproperty.getPropDate(),
                        tempproperty.getPrice(),
                        tempproperty.getImg(),
                        tempproperty.getImg(),
                        tempproperty.gettype());

                mrecentview.add(tempProp);

            }

        mtype.setText(mtype.getText());

        int imageResource = getResources().getIdentifier(tempproperty.getImg(),null, this.getPackageName());
        mpropImg.setImageResource(imageResource);

        Bundle bundle = new Bundle();
        bundle.putString("address", tempproperty.getPropAdd());
        bundle.putInt("height", 600);
        // set Fragmentclass Arguments
        DetailmapFragment dfragment = new DetailmapFragment();
        dfragment.setArguments(bundle);


        getSupportFragmentManager().beginTransaction().replace(R.id.mapShow, dfragment).commit();

        mbuyNow = (Button)findViewById(R.id.buyNow);

        mbuyNow.setOnClickListener(new View.OnClickListener() {

            public void onClick(View pa) {

                mUser = UserCheckout.getInstance();

                if(mUser.getUserLoginState().equals("Y") && !mUser.getUserEmail().isEmpty() && !mUser.getUserPassword().isEmpty()) {
                    Intent dActivity = new Intent(getApplicationContext(), CheckoutActivity.class);
                    dActivity.putExtra("Position", mPosition);
                    dActivity.putExtra("User", mUser);
                    startActivity(dActivity);
                } else {
                    //mUser.setPropertyName(tempproperty.getPropName());
                    //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    Intent dActivity = new Intent(getApplicationContext(), LoginActivity.class);
                    dActivity.putExtra("Position", mPosition);
                    startActivity(dActivity);
                }

            }

        });

    }



}
