package com.example.Conestoga_Real_Estate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {

    // This is the actual database
    private SQLiteDatabase db = null;

    public static DataManager mDbManager = null;

    /*
        Next we have a public static final string for
        each row/table that we need to refer to both
        inside and outside this class
    */

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_EMAIL = "email";
    public static final String TABLE_ROW_PHONE = "phone";
    public static final String TABLE_ROW_PASSWORD = "password";
    public static final String TABLE_ROW_LOGIN_STATE = "login_state";
    public static final String TABLE_ROW_SELECTED_HOUSE = "house";
    public static final String TABLE_ROW_PRICE = "price";
    public static final String TABLE_ROW_PAYMENT = "payment";

    /*
        Next we have a private static final strings for
        each row/table that we need to refer to just
        inside this class
    */

    private static final String DB_NAME = "customer_management_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_CUSTOMERS = "customer_info";

    public static DataManager getInstance(Context context) {
        if(mDbManager == null) {
            mDbManager = new DataManager(context);
        }

        return mDbManager;
    }

    public DataManager(Context context) {
        // Create an instance of our internal CustomSQLiteOpenHelper class
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);

        // Get a writable database
        //mDB = helper.getWritableDatabase();

        try {
            db = helper.getWritableDatabase();
        } catch(SQLiteException e) {
            Log.i("DataManager", "Constructor get DB error: " + e);
            throw e;
        }
    }

    // Here are all our helper methods

    // Insert a record
    public void insert(String name, String email, String phone, String password, String login, String selected, String price, String payment){

        // Add all the details to the table
        String query = "INSERT INTO " + TABLE_CUSTOMERS + " (" +
                TABLE_ROW_NAME + ", " +
                TABLE_ROW_EMAIL + ", " +
                TABLE_ROW_PHONE + ", " +
                TABLE_ROW_PASSWORD + ", " +
                TABLE_ROW_LOGIN_STATE + ", " +
                TABLE_ROW_SELECTED_HOUSE + ", " +
                TABLE_ROW_PRICE + ", " +
                TABLE_ROW_PAYMENT +
                ") " +
                "VALUES (" +
                "'" + name + "'" + ", " +
                "'" + email + "'" + ", " +
                "'" + phone + "'" + ", " +
                "'" + password + "'" + ", " +
                "'" + login + "'" + ", " +
                "'" + selected + "'" + ", " +
                "'" + price + "'" + ", " +
                "'" + payment + "'" +
                ");";

        Log.i("insert() = ", query);

        try {
            db.execSQL(query);
        } catch(SQLiteException e) {
            Log.i("DataManager", "Insert error: " + e);
            throw e;
        }

    }


    // Update a record
    public void updateLoginState(String email, String login) {

        String query = "UPDATE " + TABLE_CUSTOMERS +
                " SET " + TABLE_ROW_LOGIN_STATE + " = '" + login + "'" +
                " WHERE " + TABLE_ROW_EMAIL + " = '" + email + "';";

        Log.i("updateLoginState() = ", query);

        try {
            db.execSQL(query);
        } catch(SQLiteException e) {
            Log.i("DataManager", "updateLoginState error: " + e);
            throw e;
        }
    }

    public void updateCheckout(String email, String selected, String price, String payment) {

        String query = "UPDATE " + TABLE_CUSTOMERS +
                " SET " + TABLE_ROW_SELECTED_HOUSE + " = '" + selected + "',"
                         + TABLE_ROW_PRICE + " = '" + price + "', "
                         + TABLE_ROW_PAYMENT + " = '" + payment + "'" +
                " WHERE " + TABLE_ROW_EMAIL + " = '" + email + "';";

        Log.i("updateCheckout() = ", query);

        try {
            db.execSQL(query);
        } catch(SQLiteException e) {
            Log.i("DataManager", "updateCheckout error: " + e);
            throw e;
        }
    }

    // Delete a record
    public void delete(String name){

        // Delete the details from the table if already exists
        String query = "DELETE FROM " + TABLE_CUSTOMERS +
                " WHERE " + TABLE_ROW_NAME +
                " = '" + name + "';";

        Log.i("delete() = ", query);

        //mDB.execSQL(query);

        try {
            db.execSQL(query);
        } catch(SQLiteException e) {
            Log.i("DataManager", "delete error: " + e);
            throw e;
        }

    }

    // Get all the records
    public Cursor selectAll() {
        Cursor c;

        try {
            c = db.rawQuery("SELECT *" + " from " +
                    TABLE_CUSTOMERS, null);
        } catch (SQLiteException e) {
            Log.i("DataManager", "selectAll error: " + e);
            throw e;
        }

        return c;
    }

    // Find a specific record
    public Cursor searchNameAndEmail(String name, String email) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME +
                ", " + TABLE_ROW_EMAIL +
                ", " + TABLE_ROW_PHONE +
                ", " + TABLE_ROW_PASSWORD +
                ", " + TABLE_ROW_LOGIN_STATE +
                ", " + TABLE_ROW_SELECTED_HOUSE +
                ", " + TABLE_ROW_PRICE +
                ", " + TABLE_ROW_PAYMENT +
                " from " +
                TABLE_CUSTOMERS + " WHERE " +
                TABLE_ROW_EMAIL + " = '" + email + "' AND " +
                TABLE_ROW_NAME + " = '" + name + "';";

        Log.i("searchNameAndEmail() = ", query);

        //Cursor c = mDB.rawQuery(query, null);
        Cursor c;

        try {
            c = db.rawQuery(query, null);
        } catch(SQLiteException e) {
            Log.i("DataManager", "searchNameAndEmail error: " + e);
            throw e;
        }

        return c;
    }

    // Find a specific record
    public Cursor searchEmailAndPassword(String email, String password) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME +
                ", " + TABLE_ROW_EMAIL +
                ", " + TABLE_ROW_PHONE +
                ", " + TABLE_ROW_PASSWORD +
                ", " + TABLE_ROW_LOGIN_STATE +
                ", " + TABLE_ROW_SELECTED_HOUSE +
                ", " + TABLE_ROW_PRICE +
                ", " + TABLE_ROW_PAYMENT +
                " from " +
                TABLE_CUSTOMERS + " WHERE " +
                TABLE_ROW_EMAIL + " = '" + email + "' AND " +
                TABLE_ROW_PASSWORD + " = '" + password + "';";

        Log.i("searchEmailAndPW() = ", query);

        //Cursor c = mDB.rawQuery(query, null);
        Cursor c;

        try {
            c = db.rawQuery(query, null);
        } catch(SQLiteException e) {
            Log.i("DataManager", "searchEmailAndPassword error: " + e);
            throw e;
        }

        return c;
    }

    public Cursor searchName(String name) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME +
                ", " + TABLE_ROW_EMAIL +
                ", " + TABLE_ROW_PHONE +
                ", " + TABLE_ROW_PASSWORD +
                ", " + TABLE_ROW_LOGIN_STATE +
                ", " + TABLE_ROW_SELECTED_HOUSE +
                ", " + TABLE_ROW_PRICE +
                ", " + TABLE_ROW_PAYMENT +
                " from " +
                TABLE_CUSTOMERS + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';";

        Log.i("searchName() = ", query);

        //Cursor c = mDB.rawQuery(query, null);
        Cursor c;

        try {
            c = db.rawQuery(query, null);
        } catch(SQLiteException e) {
            Log.i("DataManager", "searchName error: " + e);
            throw e;
        }


        return c;
    }


    // This class is created when our DataManager is initialized
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        // This method only runs the first time the database is created
        @Override
        public void onCreate(SQLiteDatabase db) {
            
            // Create a table for photos and all their details
            String newTableQueryString = "create table "
                    + TABLE_CUSTOMERS + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null,"
                    + TABLE_ROW_NAME
                    + " text not null,"
                    + TABLE_ROW_EMAIL
                    + " text not null,"
                    + TABLE_ROW_PHONE
                    + " text not null,"
                    + TABLE_ROW_PASSWORD
                    + " text not null,"
                    + TABLE_ROW_LOGIN_STATE
                    + " text not null default 'N',"
                    + TABLE_ROW_SELECTED_HOUSE
                    + " text,"
                    + TABLE_ROW_PRICE
                    + " text,"
                    + TABLE_ROW_PAYMENT
                    + " text);";


            //db.execSQL(newTableQueryString);

            try {
                db.execSQL(newTableQueryString);
            } catch(SQLiteException e) {
                Log.i("DataManager", "onCreate error: " + e);
                throw e;
            }

        }

        // This method only runs when we increment DB_VERSION
        // We will look at this in chapter 26
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

    }

}
