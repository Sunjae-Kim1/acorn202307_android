package com.example.step01example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendBtn = findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this);

        Button sendBtn2 = findViewById(R.id.sendBtn2);
        sendBtn2.setOnClickListener(view -> {
            TextView t = findViewById(R.id.textView);
            EditText e = findViewById(R.id.editText);
            t.setText(e.getText().toString());
        });
    }

    @Override
    public void onClick(View view){
        TextView t = findViewById(R.id.textView);
        EditText e = findViewById(R.id.editText);
        t.setText(e.getText().toString());
    }
}