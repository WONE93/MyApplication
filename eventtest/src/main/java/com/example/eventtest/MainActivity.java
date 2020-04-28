package com.example.eventtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);


        //1.무명(익명)클래스
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "버튼1 클릭. ",
                        Toast.LENGTH_LONG).show(); // 창처럼 나타남
            }
        });

        //2. 인터페이스 구현 클래스
        button2.setOnClickListener(new ButtonEventHandler());
//        button2.setOnClickListener(this); 이렇게 해도됨 오버라이드만든것은 이렇게도 표현가능

        //3. view onClick= "btnPlusListener" 속성으로 버튼3 실행

        //4. 하나의 이벤트 핸들러로 여러개의 타켓을 취할예정. 여러개의 view(컴포넌트)제어
        Button.OnClickListener myclick = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button4) {
                    Toast.makeText(getApplicationContext(), "버튼4 클릭", Toast.LENGTH_LONG).show();
                } else if (v.getId() == R.id.button5) {
                    Toast.makeText(getApplicationContext(), "버튼5 클릭", Toast.LENGTH_LONG).show();
                }
            }
        };
        button4.setOnClickListener(myclick);
        button5.setOnClickListener(myclick);

    }// E of onclick

    public void butPlusListener(View v){
        Toast.makeText(getApplicationContext(), "버튼3 클릭", Toast.LENGTH_LONG).show();
    }


    //내부클래스 정의. 인터페이스 상속받아서 클레스 만듦
    class ButtonEventHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            System.out.println("버튼2 클릭");
        }
    }

} // end of EventActivity class
