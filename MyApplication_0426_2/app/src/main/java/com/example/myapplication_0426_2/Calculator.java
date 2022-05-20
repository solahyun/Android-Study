package com.example.myapplication_0426_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    // 선언
    EditText num1, num2;
    Button btn_p, btn_m, btn_mul, btn_div;
    TextView tv_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        btn_p = findViewById(R.id.btn_p);
        btn_m = findViewById(R.id.btn_m);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);

        tv_res = findViewById(R.id.tv_res);

        // 리스너 인터페이스를 상속받아 적용시키는 방법
        btn_p.setOnClickListener(this);
        btn_m.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // 1. 클릭했을 때 입력한 숫자 가져오기
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int res = 0;

        // 2. 어떤 버튼이 클릭되었는지 판단
        if(view.getId() == R.id.btn_p) {
            res = n1 + n2;
        } else if(view.getId() == R.id.btn_m) {
            res = n1 - n2;
        } else if(view.getId() == R.id.btn_mul) {
            res = n1 * n2;
        } else if(view.getId() == R.id.btn_div) {
            res = n1 / n2;
        }

        // String + 숫자 = String
        tv_res.setText("연산결과 : "+ res);
    }
}