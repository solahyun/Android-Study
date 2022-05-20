package com.example.myapplication_0426_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_num;
    Button btn_minus, btn_plus;

    // < 이벤트 적용 두번째 방식 >
    // 클릭 리스너를 상속받아서 onClick 메소드를 구현하는 방식
    // 이벤트가 비슷한 경우에 많이 사용되어짐.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_num = findViewById(R.id.tv_num);
        btn_minus = findViewById(R.id.btn_plus);
        btn_plus = findViewById(R.id.btn_minus);

        // callback으로 onClick() 불러줌
        // this -> 현재 클래스에 있는 onClick 메소드 사용한다는 의미
        btn_minus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // 어떤 버튼이 클릭되었는지 알려면?
        // -> view 객체를 통해서 알 수 있다.

        // 단순히 btn_plus는 버튼 객체이다!
        // 버튼에 대한 id값이 필요하므로 R.id.btn_plus로 해서
        // id값을 가져와야 한다.
        if(view.getId() == R.id.btn_plus) {
            String num = tv_num.getText().toString();
            int numData = Integer.parseInt(num);
            numData++;
            // numData를 String형으로 변환해서 넣어줘야 한다.
            tv_num.setText(String.valueOf(numData));

        } else if(view.getId() == R.id.btn_minus) {
            int numData = Integer.parseInt(tv_num.getText().toString());
            numData--;
            if (numData < 0) {
                numData = 0;
            }
            tv_num.setText(String.valueOf(numData));
        }
    }


    // < 이벤트 적용 첫번째 방식 >
    // 클릭되었을 때 실행할 메소드를 각각 정의해서
    // XML에 직접적으로 적용시키는 방식 -> 잘 사용하지 않는다!

//    public void plus(View view) {
//        String num = tv_num.getText().toString();
//        int numData = Integer.parseInt(num);
//        numData++;
//        // numData를 String형으로 변환해서 넣어줘야 한다.
//        tv_num.setText(String.valueOf(numData));
//    }
//
//    public void minus(View view) {
//        int numData = Integer.parseInt(tv_num.getText().toString());
//        numData--;
//        if (numData < 0) {
//            numData = 0;
//        }
//        tv_num.setText(String.valueOf(numData));
//    }

}

