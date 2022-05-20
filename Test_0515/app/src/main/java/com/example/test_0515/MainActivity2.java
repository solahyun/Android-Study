package com.example.test_0515;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private int[] nums;
    private int[] lottos = new int[6];

    private int[] comIds = {R.id.tv_com1, R.id.tv_com2, R.id.tv_com3,
            R.id.tv_com4, R.id.tv_com5, R.id.tv_com6};
    private TextView[] comTvs = new TextView[6];

    private int[] inputIds = {R.id.tv_input1, R.id.tv_input2, R.id.tv_input3,
            R.id.tv_input4, R.id.tv_input5, R.id.tv_input6};
    private TextView[] inputTvs = new TextView[6];
    private int check = 0; // 로또번호 정답 개수 저장할 변수
    private TextView tv_title;
    private HashMap<String, String> msg = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        msg();

        Intent intent = getIntent();
        nums = intent.getIntArrayExtra("nums");

        // 중복없이 로또번호 생성
        for(int i=0; i<lottos.length; i++){
            lottos[i] = new Random().nextInt(45)+1;
            for(int j=0; j<i; j++){
                if(lottos[i] == lottos[j]){
                    i--;
                }
            }
        }

        for(int i=0; i<comIds.length; i++){
            comTvs[i] = findViewById(comIds[i]);
            comTvs[i].setText(lottos[i] + "");
            inputTvs[i] = findViewById(inputIds[i]);
            inputTvs[i].setText(nums[i] +"");
        }

        // 비교
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<lottos.length; j++){
                if(lottos[i] == nums[j]){
                    check++;
                }
            }
        }

        tv_title = findViewById(R.id.tv_title);
        tv_title.setText(msg.get(check + ""));
    }

    public void msg(){
        msg.put("0", "어..? 하나도 안 맞네..?");
        msg.put("1", "에게.. 꼴랑 하나..?");
        msg.put("2", "콩라인 아쉽..");
        msg.put("3", "하나만 더 맞았어도 3등인데..?");
        msg.put("4", "3등 나름 괜찮아..?");
        msg.put("5", "2등 사실 아쉬워..");
        msg.put("6", "아싸 1등!");
    }
}