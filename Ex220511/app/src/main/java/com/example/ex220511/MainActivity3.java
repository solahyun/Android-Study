package com.example.ex220511;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    private Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_result = findViewById(R.id.btn_result);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivityForResult(intent, 1004); // 요청코드는 숫자로만 아무거나~
                // 어디에 다녀왔는지 구분을 위한 값
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // activity4에서부터 넘어온 Intent를 처리하는 부분

        if(requestCode == 1004 && resultCode == RESULT_OK) {
            Log.v("myData", data.getStringExtra("name"));
        }
    }
}