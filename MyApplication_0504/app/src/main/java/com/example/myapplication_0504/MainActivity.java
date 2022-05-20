package com.example.myapplication_0504;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_before, btn_after;
    ImageView img_pocket;

    // 이미지 관리할 배열
    // imgArray ⇒ 이미지를 가르킬 수 있는 데이터를 배열로 관리함
    int[] imgArray = {R.drawable.pocket1, R.drawable.pocket2, R.drawable.pocket3};
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_before = findViewById(R.id.btn_before);
        btn_after = findViewById(R.id.btn_after);
        img_pocket = findViewById(R.id.img_pocket);

        /*btn_before.setOnClickListener(this);
        btn_after.setOnClickListener(this);*/

        // 이벤트 적용 3번째 방법!
        // -> 리스너 인터페이스를 익명클래스로 정의해서 사용!
        // -> 리스너를 임시적으로 만들어서 버튼에 적용시킨다!
        // ->> 각각의 버튼에 있는 기능이 전혀 다르고 로직이 길어질 때
        // ->> ex. 회원가입, 로그인, 게시판 등
        btn_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if(index < 0){
                    index = 0;
                }
                img_pocket.setImageResource(imgArray[index]);
            }
        });

        btn_after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다음 버튼이 클릭되었을 때 랜덤한 이미지가 출력되게 변경!
                Random r = new Random();
                // nextInt(숫자) => 숫자-1한 숫자 중에서 랜덤한 값을 가져옴

                int num = r.nextInt(3); // 0 1 2
                img_pocket.setImageResource(imgArray[num]);

               /* index++;
                if(index == 3){
                    index = 0;
                }
                img_pocket.setImageResource(imgArray[index]);*/
            }
        });
    }

    // 이벤트 적용 1번째 방법
/*    public void change(View view){
        index++;
        img_pocket.setImageResource(imgArray[index]);
    }

    public void before(View view){
        index--;
        img_pocket.setImageResource(imgArray[index]);
    }*/

    // 이벤트 적용 2번째 방법
    // 단, 마지막 이미지에서 다음 버튼 클릭하면 첫번째 이미지로 돌아오게 하기
    /*@Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_before) {
            index--;
            if(index < 0){
                index = 0;
            }
        } else if(view.getId() == R.id.btn_after){
            index++;
            if(index == 3){
                index = 0;
            }
        }
        img_pocket.setImageResource(imgArray[index]);
    }*/
}