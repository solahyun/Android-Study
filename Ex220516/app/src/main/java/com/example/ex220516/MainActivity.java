package com.example.ex220516;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btn_request;
    private RequestQueue requestQueue;  // 서버에 요청을 하는 객체
    private StringRequest stringRequest;  // 요청 시 필요한 문자열
    private EditText edt_id, edt_pw, edt_nick, edt_phone;  // 회원 정보가 적혀있는 EditText 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_nick = findViewById(R.id.edt_nick);
        edt_phone = findViewById(R.id.edt_phone);

        btn_request = findViewById(R.id.btn_request);
        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();

            }
        });
    }

    public void sendRequest() {
        // RequestQueue 객체 생성
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        // 서버에 요청할 주소
        String url = "http://210.223.239.145:8081/web/joinInsert.do"; // 휴대폰에서 요청가능하도록 내 IPv4 입력

        // 요청 시 필요한 문자열 객체(전송방식, url, 리스너)
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);
            }
        }, new Response.ErrorListener() {
            // 서버와의 연동 에러시 출력
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override // response를 UTF8로 변경해주는 소스 코드(응답데이터 한글로 인코딩)
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }

            // 보낼 데이터를 저장하는 곳
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                String id = edt_id.getText().toString();
                String pw = edt_pw.getText().toString();
                String nick = edt_nick.getText().toString();
                String phone = edt_phone.getText().toString();
                params.put("id", id);
                params.put("pw", pw);
                params.put("nick", nick);
                params.put("phone", phone);
/*                edt_id.setText("");
                edt_pw.setText("");
                edt_nick.setText("");
                edt_phone.setText("");*/

                return params;
            }
        };
        stringRequest.setTag("main");  // 아무 값이나
        requestQueue.add(stringRequest);  // 전송
    }
}