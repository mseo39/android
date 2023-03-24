package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.EditText;

public class nickname extends AppCompatActivity {

    //============= 레이아웃 생성, 초기화 컴포넌트를 불러옴
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //프로그램 Activity가 생성할 때 실행
        setContentView(R.layout.activity_nickname);//화면 디자인을 xml로 정의해놓은 파일을 불러와 지정
    }
    
    //버튼을 클릭했을 때 실행되는 함수
    public void startButton(View view){
        //editText 참조변수 선언, 사용자로 부터 입력 받는 위젯
        EditText nameEt = (EditText)findViewById(R.id.emailEdit); //editText에서 id가 emailEdit인 것을 찾아서 변수에 저장

        //닉네임을 작성하는 곳이 비었는지 확인
        if(nameEt.getText().toString().length()!=0){
            //Intent는 메시징 객체로, 다른 앱 구성 요소로부터 작업을 요청하는 데 사용할 수 있습니다.
            // 인텐트가 구성 요소 사이의 통신을 촉진
            Intent intent = new Intent(nickname.this, Guess_num.class);
            //putExtra: 요청된 작업을 수행하는데 필요한 추가 정보가 담긴 키-쌍
            //name:(사용자가 입력한 이름)을 Guess_num으로 넘겨줌
            intent.putExtra("name", String.valueOf(nameEt.getText()));
            //액티비티를 실행
            startActivity(intent);
        }else{//만약 입력칸이 비어있다면
            nameEt.setHint("입력하세요"); //입력하라는 문구를 보여줌
        }
    }
}