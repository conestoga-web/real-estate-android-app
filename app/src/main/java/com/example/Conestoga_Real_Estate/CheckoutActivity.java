package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    int mposition = 0;
    private ArrayList<Property> mProperty;

    TextView mtxtPName;
    TextView mtxtPprice;
    TextView mtxtName;
    TextView mtxtEmail;

    RadioGroup mradioGroup;
    RadioButton mrdb;
    Button mbtnChkOut;

    Boolean valid;

    public UserCheckout mUser = null;
    public DataManager mDbManager = null;

    // A SharedPreferences for reading data
    static SharedPreferences prefs;
    // A SharedPreferences.Editor for writing data
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        mProperty = PropertyList.getInstance().getProperty();

        Bundle extras = this.getIntent().getExtras();
        if(extras != null){
            mposition = extras.getInt("Position");
        }
        Property tempproperty = mProperty.get(mposition);

        mUser = this.getIntent().getParcelableExtra("User");

        mtxtPName = (TextView)findViewById(R.id.propName);
        mtxtPprice = (TextView)findViewById(R.id.price);

        mtxtName = (TextView) findViewById(R.id.txtName);
        mtxtEmail = (TextView) findViewById(R.id.txtEmail);

        mradioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        mtxtPName.setText(tempproperty.getPropName());
        mtxtPprice.setText(tempproperty.getPrice());

        mtxtName.setText("Customer Name:   " + mUser.getUserName());
        mtxtEmail.setText("Email Address:   " + mUser.getUserEmail());

        mbtnChkOut = (Button)findViewById(R.id.btnChkOut);
        mbtnChkOut.setOnClickListener(new View.OnClickListener() {

            public void onClick(View pa) {
/*
                if(mtxtName.getText().length()==0){
                    mtxtName.requestFocus();
                    mtxtName.setError("Please Enter Your Name");
                    //Toast.makeText(CheckoutActivity.this, "Plese Enter Your Name", Toast.LENGTH_SHORT).show();
                    valid = false;
                }else{

                    valid = true;
                }

                if(android.util.Patterns.EMAIL_ADDRESS.matcher(mtxtEmail.getText().toString().trim()).matches() && mtxtEmail.getText().length()> 0 ){
                    Log.i("info","Valid Email");
                    valid = true;
                }else{

                    mtxtEmail.requestFocus();
                    mtxtEmail.setError("Please Enter Valid Email");
                    Toast.makeText(CheckoutActivity.this, "Plese Enter Your Email", Toast.LENGTH_SHORT).show();
                    valid = false;
                }
*/
                if (mradioGroup.getCheckedRadioButtonId() == -1) {

                    Toast.makeText(CheckoutActivity.this, "Plese Select Payment Method", Toast.LENGTH_SHORT).show();
                    valid = false;
                } else
                    valid = true;

                if(valid == true){

                    int radiochecked = mradioGroup.getCheckedRadioButtonId();

                    System.out.println("------------------------------- radio id----------------------"+radiochecked);
                    // find the radiobutton by returned id
                    mrdb = (RadioButton)findViewById(radiochecked);

                    mDbManager = DataManager.getInstance(getApplicationContext());
                    mDbManager.updateCheckout(mUser.getUserEmail(),
                            mtxtPName.getText().toString(),
                            mtxtPprice.getText().toString(),
                            mrdb.getText().toString());

                    //usercheckout user = new usercheckout("Pankaj", "pankaj@gmail.com", "test product", "$54646");

                    prefs = getSharedPreferences("Checkout", MODE_PRIVATE);

                    editor = prefs.edit();
                    editor.putString("Item Name", mtxtPName.getText().toString());
                    editor.putString("Item Price", mtxtPprice.getText().toString());
                    editor.putString("User Name", mtxtName.getText().toString());
                    editor.putString("User Email", mtxtEmail.getText().toString());
                    editor.putString("Payment Method", mrdb.getText().toString());
                    editor.commit();
/*
                    String itemname =  prefs.getString("ItemName", "new Item");
                    String itemprice =  prefs.getString("ItemPrice", "new Price");
                    String username =  prefs.getString("UserName", "new User");
                    String useremail =  prefs.getString("UserEmail", "new Email");
                    String paymentmethod =  prefs.getString("PaymentMethod", "new Method");
*/
/*
                    try {
                        // get JSONObject from JSON file
                        JSONObject obj = new JSONObject();
                        // fetch JSONObject named employee
                        obj.put("username", mtxtName.getText().toString());
                        obj.put("useremail", mtxtEmail.getText().toString());
                        obj.put("pname", mtxtPName.getText().toString());
                        obj.put("pprice", mtxtPprice.getText().toString());
                        obj.put("paymentmethod", mrdb.getText().toString());
                        //return obj;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
*/
/*
                    Toast.makeText(getApplicationContext(), "You Have Selected \nItem Name: "
                            +itemname+"\nItem Price: "+itemprice+
                            "\nYour Name: "+username+"\nEmail: "
                            +useremail+"\nPayment Method: "+paymentmethod, Toast.LENGTH_SHORT).show();
*/
                    //CheckoutConfirmDialog checkoutConfirmDialog = new CheckoutConfirmDialog();
                    //checkoutConfirmDialog.show(getSupportFragmentManager(), "Checkout Confirmation");

                    startActivity(new Intent(CheckoutActivity.this, CheckoutConfirmActivity.class));
                }

            }

        });

    }

}
