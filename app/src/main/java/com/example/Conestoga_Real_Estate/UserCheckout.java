package com.example.Conestoga_Real_Estate;

import android.os.Parcel;
import android.os.Parcelable;

public class UserCheckout implements Parcelable {

    private String mUserName;
    private String mUserEmail;
    private String mUserPhoneNumber;
    private String mUserPassword;
    private String mUserLoginState;
    private String mPropertyName;
    private String mPropertyPrice;
    private String mPaymentMethod;

    public UserCheckout(String uName, String uEmail, String uPhone, String password, String login, String pName, String price, String payment){
        this.mUserName = uName;
        this.mUserEmail = uEmail;
        this.mUserPhoneNumber = uPhone;
        this.mUserPassword = password;
        this.mUserLoginState = login;
        this.mPropertyName = pName;
        this.mPropertyPrice = price;
        this.mPaymentMethod = payment;

    }

    public UserCheckout() {
        this.mUserName = "";
        this.mUserEmail = "";
        this.mUserPhoneNumber = "";
        this.mUserPassword = "";
        this.mUserLoginState = "N";
        this.mPropertyName = "";
        this.mPropertyPrice = "";
        this.mPaymentMethod = "";
    }

    private static UserCheckout ourInstance = new UserCheckout();

    protected UserCheckout(Parcel in) {
        mUserName = in.readString();
        mUserEmail = in.readString();
        mUserPhoneNumber = in.readString();
        mUserPassword = in.readString();
        mUserLoginState = in.readString();
        mPropertyName = in.readString();
        mPropertyPrice = in.readString();
        mPaymentMethod = in.readString();
    }

    public static final Creator<UserCheckout> CREATOR = new Creator<UserCheckout>() {
        @Override
        public UserCheckout createFromParcel(Parcel in) {
            return new UserCheckout(in);
        }

        @Override
        public UserCheckout[] newArray(int size) {
            return new UserCheckout[size];
        }
    };

    public static UserCheckout getInstance() { return  ourInstance; }

    public void resetInstance() {
        this.mUserName = "";
        this.mUserEmail = "";
        this.mUserPhoneNumber = "";
        this.mUserPassword = "";
        this.mUserLoginState = "N";
        this.mPropertyName = "";
        this.mPropertyPrice = "";
        this.mPaymentMethod = "";
    }

    public String getUserName() {
        return mUserName;
    }

    public String getUserEmail() {
        return mUserEmail;
    }

    public String getUserPhoneNumber() {
        return mUserPhoneNumber;
    }

    public String getUserPassword() {
        return mUserPassword;
    }

    public String getUserLoginState() { return mUserLoginState; }

    public String getPropertyName() {
        return mPropertyName;
    }

    public String getPropertyPrice() { return mPropertyPrice; }

    public String getPayment() {
        return mPaymentMethod;
    }

    public void setUserName(String uName) {
        mUserName = uName;
    }

    public void setUserEmail(String uEmail) { mUserEmail = uEmail; }

    public void setUserPassword(String password) { mUserPassword = password; }

    public void setUserPhoneNumber(String uPhone) {
        mUserPhoneNumber = uPhone;
    }

    public void setUserLoginState(String login) { mUserLoginState = login; }

    public void setPropertyName(String pName) {
        mPropertyName = pName;
    }

    public void setPropertyPrice(String price) { mPropertyPrice = price; }

    public void setPayment(String payment) {
        mPaymentMethod = payment;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUserName);
        dest.writeString(mUserEmail);
        dest.writeString(mUserPhoneNumber);
        dest.writeString(mUserPassword);
        dest.writeString(mUserLoginState);
        dest.writeString(mPropertyName);
        dest.writeString(mPropertyPrice);
        dest.writeString(mPaymentMethod);
    }
}
