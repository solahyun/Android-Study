package com.example.ex220511;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        MemberVO vo = (MemberVO) intent.getSerializableExtra("vo");
        Log.v("myData", vo.toString());

//        String name = intent.getStringExtra("name");
//        int age = intent.getIntExtra("age", 0); // 내가 설정한 값이 넘어오지 않을 때는 default
//        String[] hobby = intent.getStringArrayExtra("hobby");
//
//        Log.v("myData", name);
//        Log.v("myData", age + "");
//        for(int i = 0; i < hobby.length; i++){
//            Log.v("myData", hobby[i]);
//        }
    }
}
