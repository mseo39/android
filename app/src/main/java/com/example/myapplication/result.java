package com.example.myapplication;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {
    //============= 레이아웃 생성, 초기화 컴포넌트를 불러옴
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //프로그램 Activity가 생성할 때 실행
        setContentView(R.layout.activity_result); //화면 디자인을 xml로 정의해놓은 파일을 불러와 지정

        //============== guess_num 액티비티로부터 온 데이터 받기
        Intent get_intent = getIntent();

        //Textview 참조변수를 만들어서 id가 resulttxt인것을 찾아 저장
        TextView resulttxt = (TextView)findViewById(R.id.resulttxt);
        //게임결과로 지정
        resulttxt.setText(get_intent.getStringExtra("result").toString());
        //Textview 참조변수를 만들어서 id가 myname인것을 찾아 저장
        TextView my_name = (TextView)findViewById(R.id.myname);
        //플레이어 이름으로 지정
        my_name.setText("name: "+String.valueOf(get_intent.getStringExtra("name")));
        //Textview 참조변수를 만들어서 id가 mytime인것을 찾아 저장
        TextView my_time = (TextView)findViewById(R.id.mytime);
        //게임하는데 걸린시간으로 지정
        my_time.setText("time: "+String.valueOf(30-parseInt(get_intent.getStringExtra("time"))));
    }
}