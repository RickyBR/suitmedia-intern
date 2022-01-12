package com.example.suitmedia_intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_nama,et_palin;
    TextView tv_hasil;
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nama = findViewById(R.id.et_nama);
        et_palin = findViewById(R.id.et_palin);
        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = et_nama.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", nama);
                startActivity(intent);
            }
        });


    }

    public void checkPalindrome(View view){

        char[] charInput = et_palin.getText().toString().toCharArray();
        int intLength = charInput.length;

        boolean isPalindrome = true;

        for(int i=0;i<intLength/2; i++){
            if(charInput[i] != charInput[intLength-1-i]){
                isPalindrome = false;
                break;

            }
        }
        if(isPalindrome){
            showDialog("isPalindrome");

        }
        else{
            showDialog("not palindrome");
        }


    }
    private void showDialog(String inputan){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setMessage(inputan);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}