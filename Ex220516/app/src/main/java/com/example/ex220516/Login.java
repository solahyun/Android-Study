package com.example.ex220516;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private EditText edt_login_id, edt_login_pw;
    private Button btn_login;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_login_id = findViewById(R.id.edt_login_id);
        edt_login_pw = findViewById(R.id.edt_login_pw);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
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
        String url = "http://210.223.239.145:8081/web/andLogin.do";

        // 요청 시 필요한 문자열 객체(전송방식, url, 리스너)
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);
                if(response.length() > 0) {
                    // 로그인 성공
                    try {
                        JSONObject jsonObject = new JSONObject(response);  // json 꺼내기 쉽게 변환(ctrl+alt+t)
                        String id = jsonObject.getString("id");
                        String pw = jsonObject.getString("pw");
                        String nick = jsonObject.getString("nick");
                        String phone = jsonObject.getString("phone");
                        Log.v("resultValue", id+" / " + pw + " / " + nick + " / " + phone);

                        // 로그인 성공 시 id, pw, nick, phone 데이터를 LoginSuccess Activity로
                        // 전달해서 TextView에 보여주게 하시오.
                        // 단, MemberVO로 만들어서 활용할 것-!

                        LoginCheck.info = new MemberVO(id, pw, nick, phone);
                        // LoginCheck의 info필드 안에 MemberVO 객체 생성해서 담아줌!
                        Intent intent = new Intent(getApplicationContext(), LoginSuccess.class);
                        startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {

                    }
                } else {
                    // 로그인 실패
                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                }
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

                String id = edt_login_id.getText().toString();
                String pw = edt_login_pw.getText().toString();

                params.put("id", id);
                params.put("pw", pw);

                return params;
            }
        };
        stringRequest.setTag("main");  // 구분
        requestQueue.add(stringRequest);  // 전송
    }
}