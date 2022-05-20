package com.example.myapplication_0425;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mainBack; // 객체 선언
    boolean btnStatus = true; // 전역 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // xml -> 실질적으로 보여지게 해주는 부분(onCreate)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBack = findViewById(R.id.mainBack);
    }

    // 버튼 클릭했을 때 실행되는 메소드 : 배경색 변경
    // 누가(어떤 객체) 클릭했는지 알기 위해서 View 객체 필요함!
    public void onClick(View v) {
        if (btnStatus){
            // 버튼을 한 번 클릭했을 때 원하는 색상으로 바뀌어 지게끔
            mainBack.setBackgroundColor(Color.parseColor("#fff59d"));
            btnStatus = false;
        } else {
            // 버튼을 한 번 더 클릭했을 때 다시 흰색으로 돌아오게끔
            mainBack.setBackgroundColor(Color.parseColor("white"));
            btnStatus = true;
        }
    }

}