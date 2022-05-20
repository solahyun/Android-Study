package com.example.ex220510;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends AppCompatActivity {

    private Button btn_moveB;
    private EditText edt_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        edt_input = findViewById(R.id.edt_input);
        btn_moveB = findViewById(R.id.btn_moveB);
        btn_moveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = edt_input.getText().toString();
                Intent intent = new Intent(getApplicationContext(), ActivityB.class);
                                        // 현재 액티비티(= ActivityA.this), 내가 실행시키고자 하는 액티비티
                intent.putExtra("value", value);
                startActivity(intent);
                finish(); // 현재 액티비티 종료(뒤로가기 x)
            }
        });
    }
}