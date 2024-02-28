//package com.example.yt;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//import java.util.ArrayList;
//
//public class Database extends SQLiteOpenHelper {
//    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String qry1 = "create table users(username text,email text,password text)";
//        sqLiteDatabase.execSQL(qry1);
//
//        String qry2 = "create table cart(username text,product text,price float,otype text)";
//        sqLiteDatabase.execSQL(qry2);
//
//        String qry3 = "create table report(name TEXT, age INTEGER, height REAL, weight REAL, haemoglobin REAL, RBCcount REAL, PCV REAL, leukocyte REAL, PC REAL)";
//        sqLiteDatabase.execSQL(qry3);
//
//        String qry4 = "create table orderplace(username text,fullname text,address text,contactno text,pincode int,date text,time text,amount float,otype text)";
//        sqLiteDatabase.execSQL(qry4);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//    }
//    public void register(String username,String email,String password){
//        ContentValues cv = new ContentValues();
//        cv.put("username",username);
//        cv.put("email",email);
//        cv.put("password",password);
//        SQLiteDatabase db = getWritableDatabase();
//        db.insert("users",null,cv);
//        db.close();
//    }
//
//    public int login(String username,String password){
//        int result = 0;
//        String str[]= new String[2];
//        str[0]=username;
//        str[1]=password;
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor c =db.rawQuery("select * from users where username=? and password=?",str);
//        if(c.moveToFirst()){
//            result=1;
//        }
//        return result;
//    }
//
//    public void addCart(String username,String product,float price,String otype){
//        ContentValues cv = new ContentValues();
//        cv.put("username",username);
//        cv.put("product",product);
//        cv.put("price",price);
//        cv.put("otype",otype);
//        SQLiteDatabase db = getWritableDatabase();
//        db.insert("cart",null,cv);
//        db.close();
//    }
//    public int checkCart(String username, String product) {
//        int result=0;
//        String str[] = new String [2];
//        str[0] = username;
//        str[1] = product;
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor c = db.rawQuery("select * from cart where username = ? and product = ?",str);
//        if (c.moveToFirst()) {
//            result=1;
//        }
//        db.close();
//        return result;
//    }
//    public void removeCart(String username, String otype) {
//        String str[] = new String[2];
//        str[0]= username;
//        str[1] = otype;
//        SQLiteDatabase db = getWritableDatabase();
//        db.delete ("cart","username=? and otype=?", str);
//        db.close();
//    }
//    public ArrayList getCartData(String username, String otype){
//        ArrayList<String> arr = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        String str[]= new String[2];
//        str[0]=username;
//        str[1]=otype;
//        Cursor c = db.rawQuery("select * from cart where username = ? and otype = ?",str);
//        if(c.moveToFirst()){
//            do{
//                String product = c.getString(1);
//                String price = c.getString(2);
//                arr.add(product+"$"+price);
//            }while(c.moveToNext());
//        }
//        db.close();
//        return arr;
//    }
//
//    public void addOrder (String username,String fullname,String address,String contact,int pincode,String date,String time,float price,String otype){
//    ContentValues cv = new ContentValues();
//    cv.put("username", username);
//    cv.put("fullname", fullname);
//    cv.put("address", address);
//    cv.put("contactno", contact);
//    cv.put("pincode", pincode);
//    cv.put("date", date);
//    cv.put("time", time);
//    cv.put("amount", price);
//    cv.put("otype", otype);
//    SQLiteDatabase db = getWritableDatabase ();
//    db.insert("orderplace",null, cv);
//    db.close();
//    }
//
//    public ArrayList getOrderData(String username){
//        ArrayList<String> arr = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        String str[]= new String[1];
//        str[0]=username;
//        Cursor c = db.rawQuery("select * from orderplace where username = ?",str);
//        if(c.moveToFirst()){
//            do{
//                arr.add(c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getString(4)+"$"+c.getString(5)+"$"+c.getString(6)+"$"+c.getString(7)+"$"+c.getString(8));
//            }while(c.moveToNext());
//        }
//        db.close();
//        return arr;
//    }
//
//    public void report_input(String name, int age, float height, float weight, float haemoglobin, float RBCcount, float PCV, float leukocyte, float PC) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("name", name);
//        cv.put("age", age);
//        cv.put("height", height);
//        cv.put("weight", weight);
//        cv.put("haemoglobin", haemoglobin);
//        cv.put("RBCcount", RBCcount);
//        cv.put("PCV", PCV);
//        cv.put("leukocyte", leukocyte);
//        cv.put("PC", PC);
//        db.insert("report", null, cv);
//        db.close();
//    }
//
//    public ArrayList<String> getReportData() {
//        ArrayList<String> reportData = new ArrayList<>();
//        SQLiteDatabase db = null;
//        Cursor cursor = null;
//
//        try {
//            db = getReadableDatabase();
//            cursor = db.rawQuery("SELECT * FROM report", null);
//
//            if (cursor.moveToFirst()) {
//                int nameIndex = cursor.getColumnIndex("name");
//                int ageIndex = cursor.getColumnIndex("age");
//                int heightIndex = cursor.getColumnIndex("height");
//                int weightIndex = cursor.getColumnIndex("weight");
//                int haemoglobinIndex = cursor.getColumnIndex("haemoglobin");
//                int rbcCountIndex = cursor.getColumnIndex("RBCcount");
//                int pcvIndex = cursor.getColumnIndex("PCV");
//                int leukocyteIndex = cursor.getColumnIndex("leukocyte");
//                int pcIndex = cursor.getColumnIndex("PC");
//
//                do {
//                    if (nameIndex != -1) {
//                        String name = cursor.getString(nameIndex);
//                        int age = cursor.getInt(ageIndex);
//                        float height = cursor.getFloat(heightIndex);
//                        float weight = cursor.getFloat(weightIndex);
//                        float haemoglobin = cursor.getFloat(haemoglobinIndex);
//                        float rbcCount = cursor.getFloat(rbcCountIndex);
//                        float pcv = cursor.getFloat(pcvIndex);
//                        float leukocyte = cursor.getFloat(leukocyteIndex);
//                        float pc = cursor.getFloat(pcIndex);
//
//                        String report = "Name: " + name + "\nAge: " + age + "\nHeight: " + height + "\nWeight: " + weight +
//                                "\nHaemoglobin: " + haemoglobin + "\nRBCcount: " + rbcCount + "\nPCV: " + pcv +
//                                "\nLeukocyte: " + leukocyte + "\nPC: " + pc;
//
//                        reportData.add(report);
//                    }
//                } while (cursor.moveToNext());
//            }
//        } catch (Exception e) {
//            // Handle any exceptions, e.g., database connection issues or query errors.
//            e.printStackTrace();
//        } finally {
//            if (cursor != null) {
//                cursor.close();
//            }
//            if (db != null) {
//                db.close();
//            }
//        }
//
//        return reportData;
//    }
//}
//
//
//
//
//
////    public void report_input(String name,int age,float height,float weight,float haemoglobin,float RBCcount,float PCV,float leukocyte,float PC){
////        ContentValues cv = new ContentValues();
////        cv.put("name",name);
////        cv.put("age",age);
////        cv.put("height",height);
////        cv.put("weight",weight);
////        cv.put("haemoglobin",haemoglobin);
////        cv.put("RBCcount",RBCcount);
////        cv.put("PCV",PCV);
////        cv.put("leukocyte",leukocyte);
////        cv.put("PC",PC);
////        SQLiteDatabase db = getWritableDatabase();
////        db.insert("report",null,cv);
////        db.close();
////    }




package com.example.yt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create the necessary database tables on first run
        String createUserTableQuery = "CREATE TABLE users(username TEXT, email TEXT, password TEXT)";
        sqLiteDatabase.execSQL(createUserTableQuery);

        String createCartTableQuery = "CREATE TABLE cart(username TEXT, product TEXT, price REAL, otype TEXT)";
        sqLiteDatabase.execSQL(createCartTableQuery);

        String createReportTableQuery = "CREATE TABLE report(name TEXT, age INTEGER, height REAL, weight REAL, haemoglobin REAL, RBCcount REAL, PCV REAL, leukocyte REAL, PC REAL)";
        sqLiteDatabase.execSQL(createReportTableQuery);

        String createOrderPlaceTableQuery = "CREATE TABLE orderplace(username TEXT, fullname TEXT, address TEXT, contactno TEXT, pincode INTEGER, date TEXT, time TEXT, amount REAL, otype TEXT)";
        sqLiteDatabase.execSQL(createOrderPlaceTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Handle database schema upgrades
    }

    public void register(String username, String email, String password) {
        // Register a new user
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);

        SQLiteDatabase db = getWritableDatabase();
        try {
            db.insert("users", null, cv);
        } finally {
            db.close();
        }
    }

    public int login(String username, String password) {
        // Perform user login and return result
        int result = 0;
        String[] params = new String[]{username, password};
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", params);
            if (c.moveToFirst()) {
                result = 1;
            }
        } finally {
            db.close();
        }
        return result;
    }

    public void addCart(String username, String product, float price, String otype) {
        // Add an item to the user's cart
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", product);
        cv.put("price", price);
        cv.put("otype", otype);

        SQLiteDatabase db = getWritableDatabase();
        try {
            db.insert("cart", null, cv);
        } finally {
            db.close();
        }
    }

    public int checkCart(String username, String product) {
        // Check if an item exists in the user's cart
        int result = 0;
        String[] params = new String[]{username, product};
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery("SELECT * FROM cart WHERE username=? AND product=?", params);
            if (c.moveToFirst()) {
                result = 1;
            }
        } finally {
            db.close();
        }
        return result;
    }

    public void removeCart(String username, String otype) {
        // Remove items from the user's cart
        String[] params = new String[]{username, otype};
        SQLiteDatabase db = getWritableDatabase();

        try {
            db.delete("cart", "username=? AND otype=?", params);
        } finally {
            db.close();
        }
    }

    public ArrayList<String> getCartData(String username, String otype) {
        // Get items from the user's cart
        ArrayList<String> arr = new ArrayList<>();
        String[] params = new String[]{username, otype};
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery("SELECT * FROM cart WHERE username=? AND otype=?", params);
            if (c.moveToFirst()) {
                do {
                    String product = c.getString(1);
                    String price = c.getString(2);
                    arr.add(product + "$" + price);
                } while (c.moveToNext());
            }
        } finally {
            db.close();
        }
        return arr;
    }

    public void addOrder(String username, String fullname, String address, String contact, int pincode, String date, String time, float amount, String otype) {
        // Add an order
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("fullname", fullname);
        cv.put("address", address);
        cv.put("contactno", contact);
        cv.put("pincode", pincode);
        cv.put("date", date);
        cv.put("time", time);
        cv.put("amount", amount);
        cv.put("otype", otype);

        SQLiteDatabase db = getWritableDatabase();
        try {
            db.insert("orderplace", null, cv);
        } finally {
            db.close();
        }
    }

    public ArrayList<String> getOrderData(String username) {
        // Get order data for a user
        ArrayList<String> arr = new ArrayList<>();
        String[] params = new String[]{username};
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery("SELECT * FROM orderplace WHERE username=?", params);
            if (c.moveToFirst()) {
                do {
                    arr.add(
                            c.getString(1) + "$" + c.getString(2) + "$" + c.getString(3) + "$" +
                                    c.getString(4) + "$" + c.getString(5) + "$" + c.getString(6) + "$" +
                                    c.getString(7) + "$" + c.getString(8)
                    );
                } while (c.moveToNext());
            }
        } finally {
            db.close();
        }
        return arr;
    }

    public int checkAppointmentExists(String username, String fullname, String address, String contact, String date, String time){
    int result=0;
    String str[] = new String [6];
    str[0] = username;
    str[1] = fullname;
    str[2] = address;
    str[3] = contact;
    str[4] = date;
    str[5] = time;
    SQLiteDatabase db = getReadableDatabase ();
    Cursor c= db.rawQuery("select * from orderplace where username = ? and fullname = ? and address = ? and contactno = ? and date = ? and time = ?",str);
        if (c.moveToFirst()) {
            result=1;
    }
db.close();
return result;
}

    public void report_input(String name, int age, float height, float weight, float haemoglobin, float RBCcount, float PCV, float leukocyte, float PC) {
        // Add a health report entry
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("age", age);
        cv.put("height", height);
        cv.put("weight", weight);
        cv.put("haemoglobin", haemoglobin);
        cv.put("RBCcount", RBCcount);
        cv.put("PCV", PCV);
        cv.put("leukocyte", leukocyte);
        cv.put("PC", PC);

        SQLiteDatabase db = getWritableDatabase();
        try {
            db.insert("report", null, cv);
        } finally {
            db.close();
        }
    }

    public ArrayList<String> getReportData() {
        // Get health report data
        ArrayList<String> reportData = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery("SELECT * FROM report", null);

            if (cursor.moveToFirst()) {
                int nameIndex = cursor.getColumnIndex("name");
                int ageIndex = cursor.getColumnIndex("age");
                int heightIndex = cursor.getColumnIndex("height");
                int weightIndex = cursor.getColumnIndex("weight");
                int haemoglobinIndex = cursor.getColumnIndex("haemoglobin");
                int rbcCountIndex = cursor.getColumnIndex("RBCcount");
                int pcvIndex = cursor.getColumnIndex("PCV");
                int leukocyteIndex = cursor.getColumnIndex("leukocyte");
                int pcIndex = cursor.getColumnIndex("PC");

                do {
                    if (nameIndex != -1) {
                        String name = cursor.getString(nameIndex);
                        int age = cursor.getInt(ageIndex);
                        float height = cursor.getFloat(heightIndex);
                        float weight = cursor.getFloat(weightIndex);
                        float haemoglobin = cursor.getFloat(haemoglobinIndex);
                        float rbcCount = cursor.getFloat(rbcCountIndex);
                        float pcv = cursor.getFloat(pcvIndex);
                        float leukocyte = cursor.getFloat(leukocyteIndex);
                        float pc = cursor.getFloat(pcIndex);

                        String report = "Name: " + name + "\nAge: " + age + "\nHeight: " + height + "\nWeight: " + weight +
                                "\nHaemoglobin: " + haemoglobin + "\nRBCcount: " + rbcCount + "\nPCV: " + pcv +
                                "\nLeukocyte: " + leukocyte + "\nPC: " + pc;

                        reportData.add(report);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return reportData;
    }
}
