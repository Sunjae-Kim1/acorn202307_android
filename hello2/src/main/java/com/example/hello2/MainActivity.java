package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/*
    MainActivity 는 hello2 앱이 launch 될 때마다 최초로 사용자를 대면하는 Activity 이다.
    대체로 Activity 하나는 화면 하나 이다.
 */

public class MainActivity extends AppCompatActivity {
    // Activity 가 활성화 될 때 최초 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개해서 화면 구성
        setContentView(R.layout.activity_main);
    }

    // 버튼을 누를 시 호출되는 메소드 ( View 객체의 참조값이 매개변수에 전달된다. )
    public void clicked(View v){
        Toast.makeText(this, "버튼 클릭", Toast.LENGTH_SHORT).show();
    }

    public void deleteClicked(View v){
        Toast.makeText(this, "삭제합니다.", Toast.LENGTH_SHORT).show();
    }
}