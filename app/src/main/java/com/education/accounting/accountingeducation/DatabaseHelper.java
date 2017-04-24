package com.education.accounting.accountingeducation;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String  DB_NAME = "user.db";
    public static final String  TB_NAME = "user_table";
    public static final String  COL_1 = "id";
    public static final String  COL_2 = "nama";
    public static final String  COL_3 = "hasil_pengamatan";
    public static final String  COL_4 = "pertanyaan";
    public static final String  COL_5 = "skor_pg";
    public static final String  COL_6 = "skor_tf";



    public DatabaseHelper(final Context context) {
        super(context, DB_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TB_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_1 + " TEXT, " + COL_2 + "TEXT, " + COL_3 + "TEXT, " + COL_4 + "TEXT, "+
        COL_5 + " INTEGER, " + COL_6 + " INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TB_NAME);
        onCreate(db);
    }

    public long lastID () {
        SQLiteDatabase db = this.getReadableDatabase();
        long cnt  = DatabaseUtils.queryNumEntries(db, TB_NAME);
        db.close();
        return cnt;
    }

    public boolean inisialisasi (String nama) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nama);
        contentValues.put(COL_3, "");
        contentValues.put(COL_4, "");
        contentValues.put(COL_5, "");
        contentValues.put(COL_6, "");
        long result = db.insert(TB_NAME,null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;

    }


}


