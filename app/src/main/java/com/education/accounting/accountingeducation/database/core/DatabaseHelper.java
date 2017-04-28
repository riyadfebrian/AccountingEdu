package com.education.accounting.accountingeducation.database.core;

import com.education.accounting.accountingeducation.database.table.user;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "user.sqlite";

    public  DatabaseHelper(final Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("sqlite", "database Create started");
        db.execSQL(user.table.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(user.table.DROP_QUERY);
        onCreate(db);
    }

    public int Count() {
        String countQuery = "SELECT  * FROM " + user.table.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }


}
