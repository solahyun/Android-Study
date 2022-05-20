package com.example.ex220511;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> item = new ArrayList<String>();
    private EditText edt_input;
    private Button btn_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listView = findViewById(R.id.listView);
        edt_input = findViewById(R.id.edt_input);
        btn_input = findViewById(R.id.btn_input);

        item.add("돈까스김밥");
        item.add("탕수육");
        item.add("떡볶이");
        item.add("찰떡팥빙수");
        item.add("타코야키");
/*        item.add("씨앗호떡");
        item.add("달걀찜");
        item.add("카야프레첼");
        item.add("순대국밥");
        item.add("비빔국수");
        item.add("아이스라떼");
        item.add("돌솥비빔밥");
        item.add("순대국밥");
        item.add("보리굴비");*/

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, item);
                                                          // 어플에 대한 정보, 적용될 디자인(기본), 뷰에 들어갈 데이터
        listView.setAdapter(adapter); // 어댑터 설정

        // 개별로 item 클릭 감지해서 토스트 메세지
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                   // 리스트뷰의 클릭한 어댑터, 리스트뷰, 클릭 위치값, 누름 체크
                String value = (String)adapterView.getItemAtPosition(i);
                Toast.makeText(getApplication(), value, Toast.LENGTH_SHORT).show();
            }
        });

        // 길게 클릭했을 때 삭제시키기
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item.remove(i);
                adapter.notifyDataSetChanged(); // 변경 알림
                return false;
            }
        });

        // 데이터 추가하기
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edt_input.getText().toString();
                item.add(input);
                adapter.notifyDataSetChanged();
                edt_input.setText(""); // 변경되고 칸 비워주기
            }
        });
    }
}