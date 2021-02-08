package com.example.Conestoga_Real_Estate;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class LoginFailDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class because this dialog has a simple UI
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Dialog will have "Choose" as the title
        builder.setTitle("Sign-in Fail Notice");
        builder.setMessage("You have failed in the sign-in attempt for 3 times. Will you move to the sign-up page?")

                // An SIGN IN button that does nothing
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        System.exit(0);
                    }
                })

                // A "TO SHOWROOM" button that does nothing
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getActivity(), SignupActivity.class));
                    }

                });

        // Create the object and return it
        return builder.create();
    }
}

