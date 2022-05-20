package com.example.test_0515;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_create;
    private int[] edt_ids = {R.id.edt_num1, R.id.edt_num2, R.id.edt_num3,
            R.id.edt_num4, R.id.edt_num5, R.id.edt_num6};
    private EditText[] edt_nums = new EditText[6];
    private int[] nums = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btn_create = findViewById(R.id.btn_create);

        for(int i=0; i<edt_ids.length; i++){
            edt_nums[i] = findViewById(edt_ids[i]);
        }

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<edt_nums.length; i++){
                    nums[i] = Integer.parseInt(edt_nums[i].getText().toString());
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("nums", nums);
                startActivity(intent);
            }
        });
    }
}