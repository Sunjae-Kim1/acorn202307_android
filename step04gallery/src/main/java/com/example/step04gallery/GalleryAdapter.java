package com.example.step04gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends BaseAdapter {

    // 필요한 필드 정의
    private LayoutInflater inflater; // Layout 전개자 객체를 담을 필드
    private Context context; // 앱 Context 를 담을 필드
    private int layoutRes; // 셀의 Layout 리소스 ID 를 담을 필드
    private List<GalleryDto> list; // 모델

    public GalleryAdapter(Context context, int layoutRes, List<GalleryDto> list) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;

        // Layout 전개자 객체의 참조값을 얻어내서 필드에 저장
        inflater = LayoutInflater.from(context);
    }

    // 모델의 갯수
    @Override
    public int getCount() {
        return list.size();
    }

    // i 번째 모델
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    // i 번째 모델의 ID ( PK ) 가 있으면 리턴
    @Override
    public long getItemId(int i) {
        return list.get(i).getNum();
    }

    // i 번째 Cell 의 View 를 만들거나 수정해서 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){

            // Layout 전개자 객체를 이용해서 Cell View 를 만든다.
            convertView=inflater.inflate(layoutRes, viewGroup, false);

        }

        // position 에 해당하는 GalleryDto 를 얻어내서
        GalleryDto dto=list.get(position);
        ImageView imageView=convertView.findViewById(R.id.imageView);
        TextView textWriter=convertView.findViewById(R.id.writer);
        TextView textCaption=convertView.findViewById(R.id.caption);
        TextView textRegdate=convertView.findViewById(R.id.regdate);

        // TextView 에는 작성자 , 제목 , 등록일을 출력히고
        textWriter.setText(dto.getWriter());
        textCaption.setText(dto.getCaption());
        textRegdate.setText(dto.getRegdate());

        // ImageView 에는 Glide 를 이용해서 이미지를 출력하기
        Glide.with(context)
                .load(dto.getImagePath())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);

        // Gallery 정보가 출력된 View 객체 리턴하기
        return convertView;
    }
}