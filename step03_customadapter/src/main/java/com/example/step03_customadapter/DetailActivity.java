package com.example.step03_customadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // DetailActivity 가 활성화 되기 위해서 전달된 Intent 객체의 참조값 얻어내기
        Intent intent = getIntent();

        // "dto" 라는 키 값으로 담긴 Serializable Type 의 참조값을 얻어내서 CountryDto Type 으로 Casting
        CountryDto dto = (CountryDto)intent.getSerializableExtra("dto");

        // 선택된 Cell 에 해당하는 CountryDto 를 얻어낼 수 있다면


        //아래의 ImageView , TextView 에 해당하는 정보를 얻을 수 있다.
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(dto.getResId());
        TextView textView = findViewById(R.id.textView);
        textView.setText(dto.getContent());

        // 확인 버튼을 누를 시 Activity 종료
        Button confirmBtn = findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(view -> {
            // finish() 메소드를 호출하면 Activity 종료
            this.finish();
        });
    }
}