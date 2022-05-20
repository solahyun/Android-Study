package com.example.ex220510;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tv_result = findViewById(R.id.tv_result);

        // intent 받아옴
        Intent intent = getIntent();
        String value = intent.getStringExtra("value");
        tv_result.setText(value);
    }
}