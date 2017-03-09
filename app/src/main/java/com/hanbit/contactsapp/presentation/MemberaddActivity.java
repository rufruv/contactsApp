package com.hanbit.contactsapp.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hanbit.contactsapp.R;

public class MemberaddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberadd);
        findViewById(R.id.btGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MemberaddActivity.this,"Go List",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MemberaddActivity.this,MemberlistActivity.class));
            }
        });
    }
}
