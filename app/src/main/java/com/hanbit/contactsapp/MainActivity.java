package com.hanbit.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hanbit.contactsapp.dao.DatabaseHelper;
import com.hanbit.contactsapp.presentation.MemberlistActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        findViewById(R.id.btGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Go List !", Toast.LENGTH_SHORT).show();
                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                startActivity(new Intent(MainActivity.this, MemberlistActivity.class));
            }
        });
    }
}
