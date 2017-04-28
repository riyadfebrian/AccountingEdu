package com.education.accounting.accountingeducation.database.table;

import android.provider.BaseColumns;

public class user {



    public class table implements BaseColumns {
        public static final String  TABLE_NAME = "user_table";
        public static final String  COL_2 = "nama";
        public static final String  COL_3 = "hasil_pengamatan";
        public static final String  COL_4 = "pertanyaan";
        public static final String  COL_5 = "kesimpulan";
        public static final String  COL_6 = "skor_pg";
        public static final String  COL_7 = "skor_tf";

        public static final String CREATE_QUERY = "CREATE TABLE "
                + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " TEXT, "
                + COL_5 + " TEXT, " + COL_6 + " INTEGER, " + COL_7 + " INTEGER)";

        public static final String DROP_QUERY = "drop table if exists " + TABLE_NAME;
        public static final String SElECT_QUERY = "select * from " + TABLE_NAME;
    }
}
