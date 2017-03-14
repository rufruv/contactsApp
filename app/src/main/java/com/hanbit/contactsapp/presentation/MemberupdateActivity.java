package com.hanbit.contactsapp.presentation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hanbit.contactsapp.R;
import com.hanbit.contactsapp.dao.DetailQuery;
import com.hanbit.contactsapp.domain.MemberBean;

public class MemberupdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberupdate);
        /*Intent intent = this.getIntent();
        final String id = intent.getExtras().getString("id");
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        final MemberDetail mDetail = new MemberDetail(this);
        UpdateService service = new UpdateService() {
            @Override
            public void update(Object o) {
                MemberBean temp = (MemberBean) mDetail.findOne(
                        "UPDATE Member SET phone,address,salary " +
                );
            }
        };*/


    }
    class MemberDetail extends DetailQuery {

        public MemberDetail(Context context) {
            super(context);
        }

        @Override
        public Object findOne(String sql) {
            MemberBean bean=null;
            SQLiteDatabase db=super.getDatabase();
            Cursor cursor=db.rawQuery(sql,null);

            if(cursor!=null){
                if(cursor.moveToNext()){
                    bean=new MemberBean();
                    bean.setId(cursor.getString(cursor.getColumnIndex("id")));
                    bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                    bean.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                    bean.setAge(cursor.getString(cursor.getColumnIndex("age")));
                    bean.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                    bean.setSalary(cursor.getString(cursor.getColumnIndex("salary")));
                }
            }
            return bean;
        }
    }
}
