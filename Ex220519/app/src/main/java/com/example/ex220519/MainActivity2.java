package com.example.ex220519;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv_result;
    private Button btn_start, btn_stop, btn_reset;
    private int time, min, sec, mSec;  // 분, 초, 밀리초
    private boolean isCheck = true;  //

    private Handler handler = new Handler() {
        // Thread에서 데이터를 넘겨 받아 UI/UX 부분을 수정할 수 있게 해주는 객체
        @Override
        public void handleMessage(@NonNull Message msg) {
            mSec = msg.arg1%100 ;
            sec = (msg.arg1/100)%60;
            min = (msg.arg1/100)/60;
            String result = String.format("%02d:%02d.%02d", min, sec, mSec);
            tv_result.setText(result + "");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_result = findViewById(R.id.tv_result);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        btn_reset = findViewById(R.id.btn_reset);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyThread thread = new MyThread();
                thread.start();  // 실행시키기
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCheck = false;
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = 0;
                tv_result.setText("00:00.00");
            }
        });
    }

    public class MyThread extends Thread {
        @Override
        public void run() {
            isCheck = true;
            while(isCheck) {
                try {
                    Thread.sleep(10);
                    time++;
                    Message message = new Message();
                    message.arg1 = time;
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}