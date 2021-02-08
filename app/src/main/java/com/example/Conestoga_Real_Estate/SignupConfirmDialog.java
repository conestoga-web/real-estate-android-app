package com.example.Conestoga_Real_Estate;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class SignupConfirmDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class because this dialog has a simple UI
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Dialog will have "Choose" as the title
        builder.setTitle("Congratulation!");
        builder.setMessage("Now you become a member of Conestoga Estates. Please do sign-in again on your needs.")

                // An SIGN IN button that does nothing
                .setPositiveButton("SIGN IN", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }
                })

                // A "TO SHOWROOM" button that does nothing
                .setNegativeButton("View Property", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getActivity(), ProductActivity.class));
                    }

                });

        // Create the object and return it
        return builder.create();
    }
}
