package com.example.ex220513;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class KakaoAdapter extends BaseAdapter {

    private ArrayList<KakaoVO> items = new ArrayList<KakaoVO>();

    public void addItem(Drawable img, String name, String msg, String music) {
        KakaoVO vo = new KakaoVO(img, name, msg, music);
        items.add(vo);
    }

    @Override
    public int getCount() {
        // 어댑터가 가지고 있는 아이템의 개수를 알려주는 메소드
        return items.size();
    }

    @Override
    public Object getItem(int i) { // Object로 업캐스팅
        // 어댑터에게 해당 i번째의 아이템을 요청하는 메소드
        return items.get(i);
    }

    @Override
    public long getItemId(int i) { // 잘 사용 x
        return i;
    }

    // ★★★ 제일 중요 ★★★ 필수 구현 - !
    // Adapter가 가지고 있는 item만큼 만들어놓은 xml에 틀에 맞게 넣어주는 메소드
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // kakao.xml 불러오기
        Context context = viewGroup.getContext();

        if(view == null){ // view<-ListView, 어떤 xml을 정의할지 모르고 있는 상태
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.kakao, viewGroup,false);
        }
        ImageView img = view.findViewById(R.id.img); // <- 레이아웃의 정보 view가 알고 있음
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_msg = view.findViewById(R.id.tv_msg);
        TextView tv_music = view.findViewById(R.id.tv_music);

        KakaoVO vo = items.get(i);
        img.setImageDrawable(vo.getImg());
        tv_name.setText(vo.getName());
        tv_msg.setText(vo.getMsg());
        tv_music.setText(vo.getMusic());

        return view; // view 하나의 정보 리턴
    }
}
