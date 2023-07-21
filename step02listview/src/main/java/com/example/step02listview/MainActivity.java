package com.example.step02listview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    // 필드 선언
    List<String> names;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // listView 의 참조값
        ListView listView = findViewById(R.id.listView);

        //listView 에 출력할 SampleData
        names = new ArrayList<>();

        names.add("김구라");
        names.add("해골");
        names.add("원숭이");
        for(int i = 0; i < 100; i++){
            names.add("아무개" + i);
        }

        // listView 에 연결할 Adapter 객체
        // new ArrayAdapter ( Context , layout resources , 모델 )
        adapter = new ArrayAdapter<>(
                this ,
                android.R.layout.simple_list_item_1 ,
                names
        );

        // Adapter 를 listView 에 연결하기
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        // 버튼 리스너 등록
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(view -> {
            // 1. EditText 에 입력한 문자열을 읽어와서
            EditText e = findViewById(R.id.inputName);
            // 2. names ( 모델 ) 에 추가하고
            names.add(e.getText().toString());
            // 3. Adapter 에 names ( 모델 ) 이 변경되었다고 알린다.
            adapter.notifyDataSetChanged();

            // 4. 마지막 위치까지 부드럽게 스크롤
            int position = adapter.getCount(); // 전체 아이템의 갯수
            listView.smoothScrollToPosition(position);
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // i 는 클릭한 Item 의 인덱스 값
        Log.d("MainActivity" , "i: " + i);

        // 클릭한 Item 에 출력된 이름
        String clickedName = names.get(i);

        // 토스트 ( 가벼운 메세지 ) 출력
        Toast.makeText(this , clickedName , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

//        // 알림창에 있는 버튼을 누를 시 호출되는 메소드를 가지고 있는 리스너 객체
//        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialogInterface , int result){
//                if(result == DialogInterface.BUTTON_POSITIVE){ // 긍정 버튼을 누를 시
//                    // i 번째 인덱스 의 아이템을 제거
//                    // 모델에서 제거
//                    names.remove(i);
//                    // 모델에서 변경되었다고 Adapter 에 알리면 listView 가 업데이트 된다.
//                    adapter.notifyDataSetChanged();
//                }
//            }
//        };


//        new AlertDialog.Builder(this)
//                .setTitle("알림")
//                .setMessage("삭제하나요?")
//                // .setNeutralButton("확인" , null)
//                .setPositiveButton("네" , listener)
//                .setNegativeButton("아니요" , listener)
//                .create()
//                .show();

        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage("삭제하나요?")
                .setPositiveButton("네" , (a , b) -> {
                    names.remove(i);
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("아니요" , null)
                .create()
                .show();

        return false;
    }

}