package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutConfirmActivity extends AppCompatActivity {

    public DataManager mDbManager = null;
    public UserCheckout mUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_confirm);

        TextView txtPropNameCF = (TextView)findViewById(R.id.txtPropNameCF);
        TextView txtPriceCF = (TextView)findViewById(R.id.txtPriceCF);
        TextView txtUserNameCF = (TextView)findViewById(R.id.txtUserNameCF);
        TextView txtEmailCF = (TextView)findViewById(R.id.txtEmailCF);
        TextView txtPaymentCF = (TextView)findViewById(R.id.txtPaymentCF);
        TextView txtSignOutCF = (TextView)findViewById(R.id.txtSignOutCF);
        Button btnCheckoutCF = (Button)findViewById(R.id.btnCheckoutCF);

        String itemName =  CheckoutActivity.prefs.getString("Item Name", "new Item");
        String itemPrice =  CheckoutActivity.prefs.getString("Item Price", "new Price");
        String userName =  CheckoutActivity.prefs.getString("User Name", "new User");
        final String userEmail =  CheckoutActivity.prefs.getString("User Email", "new Email");
        String paymentMethod =  CheckoutActivity.prefs.getString("Payment Method", "new Method");

        txtPropNameCF.setText("Property Name:  " + itemName);
        txtPriceCF.setText("Price:  " + itemPrice);
        txtUserNameCF.setText(userName);
        txtEmailCF.setText(userEmail);
        txtPaymentCF.setText("Payment Method:  " + paymentMethod);
        txtSignOutCF.setText("*** Sign-out will be executed on clicking 'DONE' ***");

        mDbManager = DataManager.getInstance(getApplicationContext());
        mUser = UserCheckout.getInstance();

        btnCheckoutCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDbManager.updateLoginState(mUser.getUserEmail(), "N");
                mUser.resetInstance();
                startActivity(new Intent(CheckoutConfirmActivity.this, MainActivity.class));
            }
        });
    }
}
