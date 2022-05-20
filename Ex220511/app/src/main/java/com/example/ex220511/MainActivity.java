package com.example.ex220511;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                String name = "박호두";
                int age = 20;
                String[] hobby = {"등산", "물멍", "요리", "영화"};

                MemberVO vo = new MemberVO(name, age, hobby);

                intent.putExtra("vo", vo);

                startActivity(intent);
            }
        });
    }
}