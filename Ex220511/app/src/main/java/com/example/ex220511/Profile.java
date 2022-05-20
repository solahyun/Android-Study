package com.example.ex220511;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

    private Button btn_camera;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btn_camera = findViewById(R.id.btn_camera);
        img = findViewById(R.id.img);

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000 && resultCode == RESULT_OK) {
            // 이미지 꺼내기(이미지가 번들타입으로 변환되어 넘어옴)
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data"); // 다운캐스팅
            img.setImageBitmap(bitmap);
        }
    }
}