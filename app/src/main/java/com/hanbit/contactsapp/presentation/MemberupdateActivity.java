package com.hanbit.contactsapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hanbit.contactsapp.R;
import com.hanbit.contactsapp.dao.DetailQuery;
import com.hanbit.contactsapp.dao.UpdateQuery;
import com.hanbit.contactsapp.domain.MemberBean;
import com.hanbit.contactsapp.service.DetailService;

import java.util.HashMap;
import java.util.Map;

public class MemberupdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberupdate);
        Intent intent = this.getIntent();
        final Map<String,String>map = new HashMap<>();
        final String id = intent.getExtras().getString("id");
        final MemberDetail detail = new MemberDetail(MemberupdateActivity.this);
        final MemberUpdate update = new MemberUpdate(MemberupdateActivity.this);
        DetailService service = new DetailService() {
            @Override
            public Object findOne(Map<?, ?> map) {
                String sql = String.format("","");
                MemberBean member = (MemberBean) detail.findOne(sql);
                return member;
            }
        };
    }
    class MemberDetail extends DetailQuery{

        public MemberDetail(Context context) {
            super(context);
        }

        @Override
        public Object findOne(String sql) {
            MemberBean bean = null;
            SQLiteDatabase db = super.getDatabase();
            Cursor cursor = db.rawQuery(sql,null);
            if(cursor!=null){
                if(cursor.moveToNext()){
                    bean = new MemberBean();
                    String id = cursor.getString(cursor.getColumnIndex("id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String age = cursor.getString(cursor.getColumnIndex("age"));
                    String phone = cursor.getString(cursor.getColumnIndex("phone"));
                    String address = cursor.getString(cursor.getColumnIndex("address"));
                    String salary = cursor.getString(cursor.getColumnIndex("salary"));
                    bean.setId(id);
                    bean.setName(name);
                    bean.setAddress(address);
                    bean.setAge(age);
                    bean.setPhone(phone);
                    bean.setSalary(salary);
                }
            }
            return bean;
        }
    }
    class MemberUpdate extends UpdateQuery{

        public MemberUpdate(Context context) {
            super(context);
        }

        @Override
        public void update(String sql) {
            super.getDatabase().execSQL(sql);
        }
    }
}
