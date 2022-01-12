package com.example.suitmedia_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv_nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_nama = findViewById(R.id.tv_nama);
        String nama= getIntent().getStringExtra("data");
        tv_nama.setText(nama);
    }
}