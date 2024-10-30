package com.yoga.projectpro;
import static android.icu.text.MessagePattern.ArgType.SELECT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "SignLog.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "SignLog.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        String query1 = ("create Table users(username TEXT primary key,name TEXT ,password TEXT,age TEXT,email TEXT)");
        MyDatabase.execSQL(query1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i2) {
        MyDB.execSQL("drop Table if exists users");

        onCreate(MyDB);
    }

    public Boolean insertData(String username, String name, String age,String email,String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("name", name);
        contentValues.put("age", age);
        long result = MyDatabase.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            MyDatabase.close();
            return true;
        }
    }

    public Boolean checkEmail(String username) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            MyDatabase.close();
            return false;
        }
    }

    public Boolean checkEmailPassword(String username, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            MyDatabase.close();

            return false;
        }
    }
    //created bu Super SAM
    public boolean deleteRecord(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Check if email and password match
        Cursor cursor = db.rawQuery("SELECT * FROM users" +
                " WHERE username = ? AND " +
                "password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            // Password matched, delete the tuple
            int rowsDeleted = db.delete("users",
                    "username = ? AND password = ?",
                    new String[]{username, password});
            cursor.close();
            return rowsDeleted > 0;
        } else {
            // No matching record found
            cursor.close();
            return false;
        }
    }
    //created bu Super SAM OVER

//    public boolean deleteUser(String email) {
//        SQLiteDatabase db = getWritableDatabase();
//        int deletedRows = db.delete("users", "email = ?", new String[]{email});
//        db.close();
//        return deletedRows > 0;
//    }

//    public void updateprofile(String email, String Username, String password, String age,String name) {
//        ContentValues cv = new ContentValues();
//        cv.put("email", email);
//        cv.put("Username", Username); // Changed column name to 'Username'
//        cv.put("password", password); // Changed column name to 'password'
//        cv.put("name", name);
//        cv.put("age", age);
//        SQLiteDatabase db = getWritableDatabase();
//        db.insert("profile", null, cv);
//        db.close();
//    }



    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

    public void updatePassword(String username, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password", newPassword);
        db.update("users", values, "username = ?", new String[]{username});
    }


}