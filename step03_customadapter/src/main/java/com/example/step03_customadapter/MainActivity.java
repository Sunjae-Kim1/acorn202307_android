package com.example.step03_customadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // 필드
    List<CountryDto> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Adapter 에 연결할 Model 객체 생성
        countries = new ArrayList<>();

        //셈플 데이터
        countries.add(new CountryDto(R.drawable.austria,
                "오스트리아", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.belgium,
                "벨기에", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.brazil,
                "브라질", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.france,
                "프랑스", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.germany,
                "독일", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.greece,
                "그리스", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.israel,
                "이스라엘", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.italy,
                "이탈리아", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.japan,
                "일본", "그지 같은 나라~"));
        countries.add(new CountryDto(R.drawable.korea,
                "대한민국", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.poland,
                "폴란드", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.spain,
                "스페인", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.usa,
                "미국", "어쩌구.. 저쩌구.."));

        //  ListView 에 연결할 Adapter 객체 생성
        CountryAdapter adapter = new CountryAdapter(this , R.layout.listview_cell , countries);

        // ListView 의 참조값을 얻어와서
        ListView listView = findViewById(R.id.listView);

        // Adapter 연결하기
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

//        listView.setOnClickListener(view -> {
//            Intent intent = new Intent(this , SubActivity.class);
//            startActivity(intent);
//        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // DetailActivity 로 이동할 Intent 객체 생성
        Intent intent = new Intent(this , DetailActivity.class);

        // 클릭한 셀에 있는 나라의 정보
        Serializable dto = countries.get(i);

        // Intent 객체에 "dto" 라는 키 값으로 Serializable Type 인 CountryDto 객체의 참조값 전달하기
        intent.putExtra("dto" , dto);

        // startActivity() 메소드 호출 , Intent 객체 전달해서 Activity 시작
        startActivity(intent);
    }
}