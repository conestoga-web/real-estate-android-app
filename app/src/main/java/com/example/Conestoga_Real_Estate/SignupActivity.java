package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText mTxtSignUpName;
    private EditText mTxtSignUpEmail;
    private EditText mTxtSignUpPhone;
    private EditText mTxtSignUpPW;
    private EditText mTxtCheckPW;
    private Button mBtnRegister;
    private Button mBtnBackToSignIn;
    boolean valid = false;
    public DataManager mDbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final Pattern phonePattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");

        mTxtSignUpName = (EditText)findViewById(R.id.txtSignUpName);
        mTxtSignUpEmail = (EditText)findViewById(R.id.txtSignUpEmail);
        mTxtSignUpPhone = (EditText)findViewById(R.id.txtSignUpPhone);
        mTxtSignUpPW = (EditText)findViewById(R.id.txtSignUpPW);
        mTxtCheckPW = (EditText)findViewById(R.id.txtCheckPW);
        mBtnRegister = (Button)findViewById(R.id.btnRegister);
        mBtnBackToSignIn = (Button)findViewById(R.id.btnBackToSignIn);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String signUpName = mTxtSignUpName.getText().toString().trim().toUpperCase();
                String signUpEmail = mTxtSignUpEmail.getText().toString().trim();
                String signUpPhone = mTxtSignUpPhone.getText().toString().trim();
                String signUpPW = mTxtSignUpPW.getText().toString().trim();
                String checkPW = mTxtCheckPW.getText().toString().trim();


                if(signUpName.isEmpty()) {
                    mTxtSignUpName.requestFocus();
                    mTxtSignUpName.setError("Full name is a required field.");
                   // mTxtSignUpName.setHint("Full name is a required field. Please fill it.");
                    valid = false;
                }else if(signUpEmail.isEmpty()) {
                    mTxtSignUpEmail.requestFocus();
                    mTxtSignUpEmail.setError("Email address is a required field.");
                    //mTxtSignUpEmail.setHint("Email address is a required field. Please fill it.");
                    valid = false;
                } else if(!Patterns.EMAIL_ADDRESS.matcher(signUpEmail).matches()) {
                    mTxtSignUpEmail.getText().clear();
                    mTxtSignUpEmail.setError("Please enter a valid Email.");
                    //mTxtSignUpEmail.setHint("Please enter a valid email(x~x@y~y.z~z)");
                    valid = false;
                }else if(signUpPhone.isEmpty()) {
                    mTxtSignUpPhone.requestFocus();
                    mTxtSignUpPhone.setError("Phone number is a required Field.");
                    //mTxtSignUpPhone.setHint("Phone number is a required field. Please fill it.");
                    valid = false;
                } else if(!phonePattern.matcher(signUpPhone).matches()) {
                    mTxtSignUpPhone.getText().clear();
                    mTxtSignUpPhone.setError("Please enter a valid Phone Number.");
                   // mTxtSignUpPhone.setHint("Please enter a valid phone number(111-2222-3333)");
                    valid = false;
                }else if(signUpPW.isEmpty()) {
                    mTxtSignUpPW.requestFocus();
                    mTxtSignUpPW.setError("Password is a required Field.");
                    //mTxtSignUpPW.setHint("Password is a required field. Please fill it.");
                    valid = false;
                } else if(signUpPW.length() < 8) {

                    mTxtSignUpPW.getText().clear();
                    mTxtSignUpPW.setError("Password min 8 length long.");
                   // mTxtSignUpPW.setHint("Password violation for minimum length(8 length)");
                    valid = false;

                }else if(checkPW.isEmpty()) {

                    mTxtCheckPW.requestFocus();
                    mTxtCheckPW.setError("Re-Enter Password.");
                    //mTxtCheckPW.setHint("Password check is a required field. Please fill it.");
                    valid = false;

                } else if(!checkPW.equals(signUpPW)) {

                    mTxtCheckPW.getText().clear();
                    mTxtCheckPW.setError("Password Doesn't Match.");
                    //mTxtCheckPW.setHint("No consistency of password. Check your password.");
                    valid = false;

                }else{

                    valid = true;
                }

                mDbManager = DataManager.getInstance(getApplicationContext());
                Cursor cursor = mDbManager.searchNameAndEmail(signUpName, signUpEmail);

                if(valid) {
                    if(cursor.moveToFirst() && signUpName.equals(cursor.getString(1)) && signUpEmail.equals(cursor.getString(2))) {
                        Toast.makeText(SignupActivity.this,"You already have an account on Conestoga Estates", Toast.LENGTH_LONG).show();
                    } else {
                    mDbManager.insert(signUpName, signUpEmail, signUpPhone, signUpPW, "N", null, null,null);

                    //startActivity(new Intent(SignupActivity.this, RegisterConfirmActivity.class));
                    SignupConfirmDialog signupConfirmDialog = new SignupConfirmDialog();
                    signupConfirmDialog.show(getSupportFragmentManager(), "Register Confirmation");
                }
                }
            }
        });

        mBtnBackToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }
}
