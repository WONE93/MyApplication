package com.example.mymemo;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메모작성 버튼 클릭 이벤트
        Button newMemo = (Button)findViewById(R.id.btnNewMemo);
        newMemo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewMemo.class);
                startActivity(intent);

            }
        });

        load_values();

        ListView listview = findViewById(R.id.lvMemo);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                // get item
                Map<String, String> item = (Map<String, String>)parent.getItemAtPosition(position) ;

                String title = item.get("title") ;
                String content = item.get("time") ;

                // TODO : use item data.
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();
            }
        }) ;

    }// E of onclick

    private void load_values() {
        //MVC 중  Model
        ArrayList<HashMap<String, String>> list = new MemoDAO().selectAll(getApplicationContext());


        //두번재 listview에 customAdapter 연결
        ListViewAdapter adapter = new ListViewAdapter();
        adapter.setList(list);
        ListView lvCustom = findViewById(R.id.lvMemo);
        lvCustom.setAdapter(adapter);



    } // E of load_values



} // E of class
