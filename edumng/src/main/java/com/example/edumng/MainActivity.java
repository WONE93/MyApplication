package com.example.edumng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //필드확인
        TextView txUserid = findViewById(R.id.txtUserid);
        TextView txUserpw = findViewById(R.id.txtUserpw);
        TextView txUsername = findViewById(R.id.txtUsername);
        Button btnManage = findViewById(R.id.btnManage);
        //수신받은 데이터 확인
        Intent intent = getIntent();
        String userid = intent.getExtras().getString("userid");

        //수신데이터를 view에 출력
        txUserid.setText(userid);

        //관리자가 아니면 회원관리 버튼이 안보이게 처리
        if (!userid.equals("admin")) {

        }


                } // end of onCreate
            } // end of Class
