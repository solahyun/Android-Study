package com.example.ex220510;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_web, btn_camera, btn_dial, btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_web = findViewById(R.id.btn_web); // 자동으로 다운캐스팅
        btn_camera = findViewById(R.id.btn_camera);
        btn_dial = findViewById(R.id.btn_dial);
        btn_call = findViewById(R.id.btn_call);

        btn_web.setOnClickListener(this); // 클래스 안에서 구현했음을 의미
        btn_camera.setOnClickListener(this);
        btn_dial.setOnClickListener(this);
        btn_call.setOnClickListener(this);
    }

    // alt + Insert : 자동 삽입
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_web) {
            Uri uri = Uri.parse("http://www.naver.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri); // Intent 객체 생성(묵시적)
            startActivity(intent); // 출발!

        } else if(view.getId() == R.id.btn_camera) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);

        } else if(view.getId() == R.id.btn_dial) {
            Uri uri = Uri.parse("tel:01012345678");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);

        } else if(view.getId() == R.id.btn_call) {
            Uri uri = Uri.parse("tel:010-4611-5278");
            Intent intent = new Intent(Intent.ACTION_CALL, uri);

            // 권한 설정 필요!
            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},0);
                return;
            }
            startActivity(intent);
        }
    }
}