package com.hanbit.contactsapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hanbit.contactsapp.R;
import com.hanbit.contactsapp.domain.MemberBean;
import com.hanbit.contactsapp.service.ListService;

import java.util.ArrayList;

public class MemberlistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberlist);
        final MemberBean member = new MemberBean();
        final ArrayList<MemberBean> list = new ArrayList<>();
        ListService service = new ListService() {
            @Override
            public ArrayList<MemberBean> list() {
                member.setName("홍길동");
                list.add(member);
                return list;
            }
        };
        service.list();
        findViewById(R.id.btGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MemberlistActivity.this,list.get(0).getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MemberlistActivity.this,MemberdetailActivity.class);
                intent.putExtra("id","hong");
                startActivity(intent);
            }
        });
    }
}
