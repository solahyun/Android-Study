package com.example.ex220513;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private ListView listView;
    private KakaoAdapter adapter = new KakaoAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.kakaoListView);
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img1), "찰리푸스", "신곡 나왔당", "뮤직잇스마이라잎");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img4), "강하늘", "봄바람", "버스커버스커-벚꽃엔딩");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img5), "내어깨위밥", "더 행복하길..", "내사랑내곁에");

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                KakaoVO vo = (KakaoVO) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), vo.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}