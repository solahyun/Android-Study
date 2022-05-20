package com.example.ex220512;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_create;
    //private EditText edt_num1, edt_num2, edt_num3, edt_num4, edt_num5, edt_num6;
    private int[] edt_ids = {R.id.edt_num1, R.id.edt_num2, R.id.edt_num3,
            R.id.edt_num4, R.id.edt_num5, R.id.edt_num6};
    private EditText[] edt_nums = new EditText[6];
    private int[] nums = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 화면 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // 실습
        // 번호 생성 버튼 누르는 순간, edt_num1 ~ edt_num6까지
        // 사용자가 입력한 데이터를 배열로 만들어
        // Intent에 담아 MainActivity2로 이동하시오.

        btn_create = findViewById(R.id.btn_create);
        for(int i = 0; i < edt_ids.length; i++){
            edt_nums[i] = findViewById(edt_ids[i]);
        }
/*        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        edt_num3 = findViewById(R.id.edt_num3);
        edt_num4 = findViewById(R.id.edt_num4);
        edt_num5 = findViewById(R.id.edt_num5);
        edt_num6 = findViewById(R.id.edt_num6);*/

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < edt_nums.length; i++){
                    nums[i] = Integer.parseInt(edt_nums[i].getText().toString());
                }
                Intent intent =  new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("nums", nums);
                startActivity(intent);
            }
        });


    }
}