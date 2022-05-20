package com.example.myapplication_0426_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc2 extends AppCompatActivity implements View.OnClickListener {

    EditText in_n1, in_n2;
    TextView tv_result;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc2);

        // setContentView로 xml 파일이 만들어진 후에 불러올 수 있다.
        in_n1 = findViewById(R.id.in_n1);
        in_n2 = findViewById(R.id.in_n2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        tv_result = findViewById(R.id.tv_result);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // view에서 어떤 것을 선택할지!
        int n1 = Integer.parseInt(in_n1.getText().toString());
        int n2 = Integer.parseInt(in_n2.getText().toString());

        if(view.getId() == R.id.btn1){
            tv_result.setText("연산결과 : " + String.valueOf(n1+n2));
        } else if(view.getId() == R.id.btn2) {
            tv_result.setText("연산결과 : " + String.valueOf(n1-n2));
        } else if(view.getId() ==  R.id.btn3) {
            tv_result.setText("연산결과 : " + String.valueOf(n1*n2));
        } else if(view.getId() ==  R.id.btn4) {
            tv_result.setText("연산결과 : " + String.valueOf(n1/n2));

        }
    }
}