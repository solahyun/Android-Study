package com.example.ex220519;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_time;
    private Button btn_time;
    private int time;  // 시간을 저장할 변수

    private Handler handler = new Handler() {
        // Thread에서 데이터를 넘겨 받아 UI/UX 부분을 수정할 수 있게 해주는 객체
        @Override
        public void handleMessage(@NonNull Message msg) {
            // Thread로부터 데이터를 넘겨받는 메소드
            // super.handleMessage(msg);
            tv_time.setText(msg.arg1 + "");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_time = findViewById(R.id.tv_time);
        btn_time = findViewById(R.id.btn_time);

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 첫 번째 방법
                //TimeThread timeThread = new TimeThread();
                //timeThread.start();  // 실행시키기 (run메소드 아님!)

                // 두 번째 방법
                Thread t = new Thread(new InTimeThread());
                t.start();
            }
        });
    }

    // time을 1씩 올려주는 타이머 기능
    public class TimeThread extends Thread {
        @Override
        public void run() {
            // Thread를 실행시키는 메소드
            // super.run(); 부모클래스 사용 안 할 것임!
            while(true) {
                try {
                    Thread.sleep(1000);  // 1초간 스레드 멈춤(예외처리)
                    time++;
                    //tv_time.setText(time + "");
                    Message message = new Message(); // message통해 데이터 전달
                    message.arg1 = time;  // int형으로
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 두 번째 방법
    public class InTimeThread implements Runnable {
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000);  // 1초간 스레드 멈춤(예외처리)
                    time++;
                    //tv_time.setText(time + "");
                    Message message = new Message(); // message통해 데이터 전달
                    message.arg1 = time;  // int형으로
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}