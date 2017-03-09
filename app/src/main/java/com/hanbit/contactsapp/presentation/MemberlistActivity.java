package com.hanbit.contactsapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hanbit.contactsapp.R;

public class MemberlistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberlist);
        findViewById(R.id.btGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MemberlistActivity.this,"Go Detail !", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MemberlistActivity.this,MemberdetailActivity.class));
            }
        });
    }
}
