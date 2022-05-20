package com.example.ex220512;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private int[] nums; // 사용자가 입력한 로또 번호가 저장될 배열
    private int[] lottos = new int[6]; // 컴퓨터가 뽑은 로또 번호가 저장될 배열
    // 로또번호를 보여줄 textView의 아이디 배열
    private int[] comIds = {R.id.tv_com1, R.id.tv_com2, R.id.tv_com3,
                            R.id.tv_com4, R.id.tv_com5, R.id.tv_com6};
    private TextView[] comTvs = new TextView[6]; // 로또 번호를 보여줄 TextView 객체를 저장할 배열

    // 사용자가 입력한 번호를 보여줄 textView의 아이디 배열
    private int[] inputIds = {R.id.tv_input1, R.id.tv_input2, R.id.tv_input3,
                              R.id.tv_input4, R.id.tv_input5, R.id.tv_input6};
    // 사용자가 입력한 번호를 보여줄 textView 객체가 담길 배열
    private TextView[] inputTvs = new TextView[6];
    private int check = 0; // 로또번호 정답 개수를 저장할 변수
    private TextView tv_title; // 결과를 보여줄 textView
    private HashMap<String, String> message = new HashMap<String, String>(); // key(reference type), value

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        message();

        Intent intent = getIntent();
        nums= intent.getIntArrayExtra("nums");

        // 중복없이 로또 번호 생성
        for(int i = 0; i < lottos.length; i++) {
            lottos[i] = new Random().nextInt(45) + 1;
            for(int j = 0; j < i; j++) {
                if(lottos[i] == lottos[j]) {
                    i--;
                }
            }
        }

        for(int i = 0; i < comTvs.length; i++) {
            comTvs[i] = findViewById(comIds[i]);
            comTvs[i].setText(lottos[i] + "");
            inputTvs[i] = findViewById(inputIds[i]);
            inputTvs[i].setText(nums[i] + "");
        }

        for(int i = 0; i < lottos.length; i++) {
            for(int j = 0; j < lottos.length; j++) {
                if(lottos[i] == nums[j]){
                    check++;
                }
            }
        }

        tv_title = findViewById(R.id.tv_title);
        tv_title.setText(message.get(check + ""));

        /*switch(check) {
            case 6:
                tv_title.setText("1등! 추카추카~");
                break;
            case 5:
                tv_title.setText("2등! 아쉽아쉽~");
                break;
            case 4:
                tv_title.setText("3등! 그래도 좋아~");
                break;
            default:
                tv_title.setText("꽝.. 다음 기회에...");
        }*/


      }
      public void message(){
            message.put("0", "어..? 하나도 안 맞네..?");
            message.put("1", "에게.. 꼴랑 하나..?");
            message.put("2", "콩라인 아쉽..");
            message.put("3", "하나만 더 맞았어도 3등인데..?");
            message.put("4", "3등 나름 괜찮아..?");
            message.put("5", "2등 사실 아쉬워..");
            message.put("6", "아싸 1등!");
      }
}