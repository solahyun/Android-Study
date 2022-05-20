package com.example.myapplication_0504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DiceGame extends AppCompatActivity implements View.OnClickListener {

    TextView tv_result;
    ImageView iv_left, iv_right;
    Button btn;
    int diceArray[] = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
                      R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
    // 몇 번 이겼는지를 나타내주는 변수
    int l_score, r_score = 0;

    // 토스트 메세지
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_game);

        tv_result = findViewById(R.id.tv_result);
        iv_left = findViewById(R.id.iv_left);
        iv_right = findViewById(R.id.iv_right);
        btn = findViewById(R.id.btn);

        // 이벤트 2번째 방법
        btn.setOnClickListener(this);

        // 이벤트 3번째 방법
/*        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int userNum = r.nextInt(6);
                int comNum = r.nextInt(6);

                iv_left.setImageResource(diceArray[userNum]);
                iv_right.setImageResource(diceArray[comNum]);

                if(userNum > comNum){
                    l_score++;
                } else if(comNum > userNum){
                    r_score++;
                }
                tv_result.setText(l_score + " : " + r_score);
            }
        });*/
    }

    // 1. PLAY 버튼 클릭 시, 랜덤하게 주사위 모양이 바뀌게 한다.
    //  -> (두 개의 랜덤한 수를 받아와서 주사위 이미지 변경!)
    // 2. 주사위 번호가 컴퓨터가 큰지 사용자가 큰지 판단한다.
    // 3. 더 큰 주사위 번호를 가지고 있는 쪽의 스코어를 1 증가
    @Override
    public void onClick(View view) {
        Random r1 = new Random();
        Random r2 = new Random();
        int num1 = r1.nextInt(6);
        int num2 = r2.nextInt(6);

        iv_left.setImageResource(diceArray[num1]);
        iv_right.setImageResource(diceArray[num2]);

        if(num1 > num2){
            l_score++;
        } else if(num1 < num2){
            r_score++;
        }
        tv_result.setText(l_score + " : " + r_score);

        // 토스트 메세지 띄우기
        // -> 띄워졌다가 사라지는 알림창
        // -> Toast.makeText("어디에", "메시지", "유지시간");
        // -> show() : 보여주기
        if(l_score >= 10){
            toast = Toast.makeText(DiceGame.this, "당신의 승리입니다!", Toast.LENGTH_LONG);
            toast.show();
        } else if(r_score >= 10){
            toast = Toast.makeText(DiceGame.this, "컴퓨터의 승리입니다!", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
