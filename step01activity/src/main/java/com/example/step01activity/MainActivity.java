package com.example.step01activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 카운트를 셀 필드
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

    }

    // 버튼을 누를 시 실행되는 메소드
    public void clicked(View v){
        // 필드의 값을 1 증가
        count++;
        // 필드의 값을 TextView 에 출력하기
        // res/layout/activity.main.xml 문서를 전개해서 Layout 을 구성했는데
        // 그 곳에서 TextView 의 참조값을 얻어오기
        TextView a = findViewById(R.id.textView);

        a.setText(Integer.toString(count));
    }

    public void resetClicked(View v){
        count = 0;
        /*
            현재 활성화 되어 있는 Activity 가 구성한 회면에 서
            TextView 라는 아이디를 가지고 있는 UI 의 참조값 얻어와서
            TextView Type 의  a 라는 지역 변수에 담기
        */
        TextView a = findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }
}