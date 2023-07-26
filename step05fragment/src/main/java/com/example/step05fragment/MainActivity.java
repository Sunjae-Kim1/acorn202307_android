package com.example.step05fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.step05fragment.databinding.ActivityMainBinding;

// MyFragment 에서 전달하는 메세지를 받고 싶다면 Interface 를 구현
public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_main.xml 문서에 <fragment> 요소가 있다. 해당 요소의 참조값은 어떻게 얻어내지?
        // setContentView(R.layout.activity_main);

        // View Binding 객체를 얻어내서 필드에 저장
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // 화면 구성
        setContentView(binding.getRoot());

        // FragmentManager 객체 얻어오기
        FragmentManager fm = getSupportFragmentManager();

        // FragmentManager 객체를 이용해서 Fragment 객체의 참조값을 얻어낼 수 있다.
        MyFragment frag1 = (MyFragment) fm.findFragmentById(R.id.fragment1);
        MyFragment frag2 = (MyFragment) fm.findFragmentById(R.id.fragment2);

        // Reset 버튼에 리스너 등록
        // Button resetBtn = findViewById(R.id.resetBtn);
        // resetBtn.setOnClickListener(view -> {

        binding.resetBtn.setOnClickListener(view -> {
            frag1.reset();
            frag2.reset();
        });

        // Button moveBtn = findViewById(R.id.moveBtn);
        // moveBtn.setOnClickListener(view -> {

        binding.moveBtn.setOnClickListener(view -> {
            startActivity(new Intent(this , SubActivity.class));
        });
    }

    // MyFragment 객체에서 특정 시점에 호출하는 메소드
    @Override
    public void sendMsg(String msg) {
        Toast.makeText(this, "MyFragment:" + msg, Toast.LENGTH_SHORT).show();
    }
}