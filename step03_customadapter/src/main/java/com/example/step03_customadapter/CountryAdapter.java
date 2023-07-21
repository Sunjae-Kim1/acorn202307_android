package com.example.step03_customadapter;

/*
    listView 에 연결할 Adapter Class 정의하기
    - BaseAdapter 추상 Class 를 상속 받아서 만든다.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {

    //필드
    Context context;
    int layoutRes;
    List<CountryDto> list;

    // 생성자 ( Context , Cell 의 Layout Resources Id , Model )
    public CountryAdapter(Context context , int layoutRes , List<CountryDto> list){
        // 생성자의 인자로 전달된 값을 필드에 저장된다.
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
    }

    // 모델의 갯수를 리턴
    @Override
    public int getCount() {
        return list.size();
    }

    // i 번째 Index 에 해당하는 모델을 리턴
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    // i 번째 Index 에 해당하는 모델의 아이디 ( PK ) 가 있다면 리턴
    @Override
    public long getItemId(int i) {
        // 없으면 Index 를 리턴
        return i;
    }

    // i 번째 Index 에 해당하는 Cell View 를 리턴
    /*
        인자로 전달되는  i번째 Cell View 를 만들어서 리턴해야 한다.
        Cell View 는 Layout XML 문서를 전개해서 만들어야 한다.
        전개해서 만든 View 의 ImageView , TextView 에 적절한 데이터를 출력한 다음
        View 객체를 리턴한다.
        Cell View 는 모델의 갯수만큼 다 만드는 것이 아니라 최소한의 갯수만 만들어서
        기존에 만들었던 View 객체를 재사용해야 한다.
    */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.e("CountryAdapter" , "getView() 호출됨 i: " + i);

        // 만일 null 이면
        if(view == null){
            // Layout XML 문서를 전개해서 View 객체를 새로 생성한다.
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layoutRes , viewGroup , false);
        }
        // i 에 해당하는 CountryDto 객체
        CountryDto dto = list.get(i);

        // View 객체 안에 있는 ImageView , TextView 의 참조값을 얻어온다.
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        // ImageView , TextView 에 정보를 출력한다.
        imageView.setImageResource(dto.getResId());
        textView.setText(dto.getName());

        // i 번째 Index 에 해당하는 View 를 리턴한다.
        return view;
    }
}