package com.example.pr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class next extends AppCompatActivity {


    TextView t1,h;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        t1=findViewById(R.id.ans);
        h=findViewById(R.id.header);
        Intent i=getIntent();
        String s1=i.getStringExtra("s1");
        String s2=i.getStringExtra("s2");
        t1.setText(s1);
        h.setText(s2);
    }
}
