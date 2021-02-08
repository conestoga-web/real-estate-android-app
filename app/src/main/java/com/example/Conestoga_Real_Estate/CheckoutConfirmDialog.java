package com.example.Conestoga_Real_Estate;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class CheckoutConfirmDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class because this dialog has a simple UI

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String itemname =  CheckoutActivity.prefs.getString("ItemName", "new Item");
        String itemprice =  CheckoutActivity.prefs.getString("ItemPrice", "new Price");
        String username =  CheckoutActivity.prefs.getString("UserName", "new User");
        String useremail =  CheckoutActivity.prefs.getString("UserEmail", "new Email");
        String paymentmethod =  CheckoutActivity.prefs.getString("PaymentMethod", "new Method");

        // Dialog will have "Choose" as the title
        builder.setTitle("Checkout Confirmation");
        builder.setMessage("Property Name: "+itemname+"\nPrice: "+itemprice+"\n"+username+"\n"+useremail+"\nPayment Method: "+paymentmethod)
                .setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        android.os.Process.killProcess(android.os.Process.myPid());
                        //finishAndRemoveTask();
                    }
                });

        // Create the object and return it
        return builder.create();
    }
}
