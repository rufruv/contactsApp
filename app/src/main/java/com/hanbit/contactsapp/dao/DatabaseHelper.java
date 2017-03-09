package com.hanbit.contactsapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hanbit.contactsapp.domain.MemberBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2002 on 2017-03-08.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    final static String DATABASE_NAME="";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    // 데이터베이스 안에 테이블과 초기 데이터를 생성한다.
        String sql="";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Member");
        onCreate(db);
    }
    public void insert(MemberBean bean){

    };
    public MemberBean selectOne(MemberBean bean){
        MemberBean member = new MemberBean();
        return member;
    };
    public List<MemberBean> selectSome(MemberBean bean){
        List<MemberBean> listSome = new ArrayList<>();

        return listSome;
    };
    public List<MemberBean> selectAll(MemberBean bean){
        List<MemberBean> listAll = new ArrayList<>();

        return listAll;
    };
    public void update(MemberBean bean){

    };
    public void delete(MemberBean bean){

    };


}
