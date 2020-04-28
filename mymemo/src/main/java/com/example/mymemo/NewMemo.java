package com.example.mymemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewMemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memo);

        //버튼 누르면 이 창 꺼지고 다시 메인창으로 (등록하기)
        Button b1 = (Button)findViewById(R.id.insert);
        b1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                EditText editTextTitle = (EditText)findViewById(R.id.title);
                String title = editTextTitle.getText().toString() ;
                EditText editTextContent = (EditText)findViewById(R.id.content);
                String content = editTextContent.getText().toString() ;

                MemoVO vo = new MemoVO();
                vo.setTitle(title);
                vo.setContent(content);
                new MemoDAO().insert(getApplicationContext(), vo);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    } // End of onCreate

}
