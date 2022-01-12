package com.example.suitmedia_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv_nama,tv_nama2,tv_namaL;
    Button btn_check_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_nama = findViewById(R.id.tv_nama);
        tv_nama2 = findViewById(R.id.tv_nama2);
        btn_check_user = findViewById(R.id.btn_check_user);

        String nama= getIntent().getStringExtra("data");
        tv_nama.setText(nama);

        Intent intent = getIntent();
        String lala= getIntent().getStringExtra("lala");
        if(lala !=null){

            int position = intent.getExtras().getInt("position");;
            tv_nama2.setText(ThirdActivity.dataArrayList.get(position).getFirst_name());

            tv_nama.setText(nama);

        }



        btn_check_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });
    }
}