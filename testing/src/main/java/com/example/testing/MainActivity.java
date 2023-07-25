package com.example.testing;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNum = findViewById(R.id.inputNum);
        Button testBtn = findViewById(R.id.testBtn);

        testBtn.setOnClickListener(view -> {
            int num = Integer.parseInt(inputNum.getText().toString());
            if(num % 2 == 0){
                Toast.makeText(this , "짝수입니다" , Toast.LENGTH_LONG).show();
            }else if(num % 2 == 1){
                Toast.makeText(this , "홀수입니다" , Toast.LENGTH_LONG).show();
            }
        });
    }
}