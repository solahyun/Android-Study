package com.example.ex220516;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemberList extends AppCompatActivity {

    private ListView listView;  // 리스트뷰 객체
    private ArrayAdapter<String> adapter;  // 리스트뷰에 적용되는 어댑터
    // 어댑터에 들어갈 데이터
    private ArrayList<String> items = new ArrayList<String>();

    // 서버 통신
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        listView = findViewById(R.id.listView);

        // 페이지 이동이 되었을 때, 바로 목록이 보여져야 함
        sendRequest();
    }

    public void sendRequest() {
        // RequestQueue 객체 생성
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        // 서버에 요청할 주소
        String url = "http://210.223.239.145:8081/web/memberList.do";

        // 요청 시 필요한 문자열 객체(전송방식, url, 리스너)
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        // jsonObject에는 회원들의 정보가 담겨 있다.
                        // 회원들의 정보를 리스트뷰에 보이게 하시오.
                        // 1. id-pw-nick-phone
                        // 2. sol-7641-솔솔-01011112222
                        items.add((i+1) + ". " + jsonObject.get("id")+" - "+jsonObject.get("pw")+" - "+jsonObject.get("nick")+" - "+jsonObject.get("phone"));
                    }

                    adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, items);
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    // json array 타입이 아닐 경우, 예외 처리
                    e.printStackTrace();
                } finally {
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
                return params;
            }
        };
        stringRequest.setTag("main"); // 구분
        requestQueue.add(stringRequest);  // 전송
    }
}