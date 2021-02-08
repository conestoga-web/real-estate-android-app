package com.example.Conestoga_Real_Estate;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText mTxtSignInPW;
    private EditText mTxtSignInEmail;
    private Button mBtnSignIn;
    private Button mBtnSignUp;

    private int failCount = 0;

    public DataManager mDbManager = null;
    public UserCheckout mUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mTxtSignInEmail = (EditText)findViewById(R.id.txtSignUpEmail);
        mTxtSignInPW = (EditText)findViewById(R.id.txtSignInPW);
        mBtnSignIn = (Button)findViewById(R.id.btnSignIn);
        mBtnSignUp = (Button)findViewById(R.id.btnSignUp);

        mDbManager = DataManager.getInstance(getApplicationContext());

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String signInEmail = mTxtSignInEmail.getText().toString().trim();
                String signInPW = mTxtSignInPW.getText().toString().trim();

                String error = "";

                if(signInEmail.isEmpty()) {
                    error = "empty_email";
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(signInEmail.trim()).matches()) {
                    error += "invalid_email";
                }

                if(signInPW.isEmpty()) {
                    error += "+empty_pw";
                } else if (signInPW.length() < 8) {
                    error += "+invalid_pw_length";
                }

                if(error == "") {

                    if(failCount < 3) {

                        Cursor cursor = mDbManager.searchEmailAndPassword(signInEmail, signInPW);

                        if (cursor.moveToFirst()) {

                            if(!cursor.getString(5).equals("Y"))
                            mDbManager.updateLoginState(signInEmail, "Y");

                            mUser = UserCheckout.getInstance();
                            mUser.setUserLoginState("Y");
                            mUser.setUserName(cursor.getString(1));
                            mUser.setUserEmail(cursor.getString(2));
                            mUser.setUserPhoneNumber(cursor.getString(3));
                            mUser.setUserPassword(cursor.getString(4));

                            int position = 0;
                            Intent dActivity = new Intent(LoginActivity.this, DisplayActivity.class);
                            dActivity.putExtra("Position", getIntent().getIntExtra("Position", position));
                            dActivity.putExtra("classtype", "");
                            startActivity(dActivity);

                        } else {

                            mTxtSignInEmail.getText().clear();
                            mTxtSignInPW.getText().clear();

                            failCount++;

                            Toast.makeText(LoginActivity.this, "The number of your attempt is " + failCount + ".", Toast.LENGTH_LONG).show();

                            if(failCount == 3) {
                                LoginFailDialog loginFailDialog = new LoginFailDialog();
                                loginFailDialog.show(getSupportFragmentManager(), "Register Confirmation");
                            }
                        }
                    }

                } else {
                    switch(error) {
                        case "empty_email":
                            mTxtSignInEmail.requestFocus();
                            mTxtSignInEmail.setError("Please fill with your email address");
                            break;
                        case "invalid_email":
                            mTxtSignInEmail.getText().clear();
                            mTxtSignInEmail.requestFocus();
                            mTxtSignInEmail.setError("Please enter a valid email");
                            break;
                        case "+empty_pw":
                            mTxtSignInPW.requestFocus();
                            mTxtSignInPW.setError("Please fill with your password");
                            break;
                        case "+invalid_pw_length":
                            mTxtSignInPW.getText().clear();
                            mTxtSignInPW.requestFocus();
                            mTxtSignInPW.setError("Please enter a valid password");
                            break;
                        case "empty_email+empty_pw":
                            mTxtSignInEmail.requestFocus();
                            mTxtSignInEmail.setError("Please fill with your email and password");
                            break;
                        case "invalid_email+empty_pw":
                            mTxtSignInEmail.getText().clear();
                            mTxtSignInPW.getText().clear();
                            mTxtSignInEmail.requestFocus();
                            mTxtSignInEmail.setError("Please enter valid a email and fill with a password");
                            break;
                        case "empty_email+invalid_pw_length":
                            mTxtSignInEmail.getText().clear();
                            mTxtSignInPW.getText().clear();
                            mTxtSignInEmail.requestFocus();
                            mTxtSignInEmail.setError("Please fill with your email and enter a valid password");
                            break;
                        case "invalid_email+invalid_pw_length":
                            mTxtSignInEmail.getText().clear();
                            mTxtSignInPW.getText().clear();
                            mTxtSignInEmail.requestFocus();
                            mTxtSignInEmail.setError("Please enter valid email and password");
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });


    }
}
