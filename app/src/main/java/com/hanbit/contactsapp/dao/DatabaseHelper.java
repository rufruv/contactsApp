package com.hanbit.contactsapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hb2002 on 2017-03-08.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    final static String DATABASE_NAME="hanbit.db";
    final static Integer DATABASE_VERSION=1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 데이터베이스 안에 테이블과 초기 데이터를 생성한다.
        String sql = "CREATE TABLE IF NOT EXISTS Member(\n" +
                "  _id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  name TEXT,\n" +
                "  phone TEXT,\n" +
                "  age TEXT,\n" +
                "  address TEXT,\n" +
                "  salary TEXT\n" +
                ");";
        db.execSQL(sql);
        /*for (int i = 0; i < 10; i++) {
            db.execSQL(String.format("INSERT INTO Member(name,phone,age,address,salary)\n" +
                            " VALUES('%s','%s','%s','%s','%s'); \n"
                    , "홍길동" + i, "010-0000-000" + i, "2" + i, "서울", (i + 1) + "00"));
        }*/
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Member");
        onCreate(db);
    }
}
