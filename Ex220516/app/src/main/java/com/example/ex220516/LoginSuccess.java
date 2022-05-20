package com.example.ex220516;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LoginSuccess extends AppCompatActivity {

    private TextView tv_login_id, tv_login_pw, tv_login_nick, tv_login_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        tv_login_id = findViewById(R.id.tv_login_id);
        tv_login_pw = findViewById(R.id.tv_login_pw);
        tv_login_nick = findViewById(R.id.tv_login_nick);
        tv_login_phone = findViewById(R.id.tv_login_phone);

        tv_login_id.setText(LoginCheck.info.getId());
        tv_login_pw.setText(LoginCheck.info.getPw());
        tv_login_nick.setText(LoginCheck.info.getNick());
        tv_login_phone.setText(LoginCheck.info.getPhone());

        MemberVO info = LoginCheck.info;
        // 필요할 때마다 info 필드에서 정보를 꺼내서
        // MemberVO로 저장할 수 있다.

        // 로그아웃 기능
        // LoginCheck.info = null;
    }
}