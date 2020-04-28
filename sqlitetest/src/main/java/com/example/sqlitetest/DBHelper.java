package com.example.sqlitetest;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;

    public DBHelper(Context context){
        super(context, "contact.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateSQL = "CREATE TABLE IF NOT EXISTS CONTACT_T (" +
                "_NO "           + "INTEGER NOT NULL," +
                "NAME "         + "TEXT," +
                "PHONE "        + "TEXT," +
                "OVER20 "       + "INTEGER" + ")" ;
        db.execSQL(CreateSQL);

        db.execSQL("insert into  CONTACT_T values(100,'홍길동','test1@t.com',1)");
        db.execSQL("insert into  CONTACT_T values(102,'나기자','test2@t.com',0)");
        db.execSQL("insert into  CONTACT_T values(103,'김유신','test3@t.com',1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion != DATABASE_VERSION){
            db.execSQL("drop table tb_emp");
            onCreate(db);
        }
    }
}