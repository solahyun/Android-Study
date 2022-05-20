package com.example.ex220511;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    private Button btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btn_return = findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(); // 새 intent 생성!
                intent.putExtra("name", "박호두");
                setResult(RESULT_OK, intent);  // RESULT_OK = -1
                finish(); // 꼭! 현재페이지 보여주기 위함!

            }
        });
    }
}