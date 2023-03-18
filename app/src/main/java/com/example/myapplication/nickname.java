package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.EditText;

public class nickname extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
    }

    public void startButton(View view){
        //EditText et; //editText 변수 선언, 사용자로 부터 입력 받는 위젯
        EditText nameEt = (EditText)findViewById(R.id.emailEdit); //editText에서 id가 email_text인 것을 찾아서 변수에 저장

        if(nameEt.getText().toString().length()!=0){
            Intent intent = new Intent(nickname.this, Guess_num.class);
            intent.putExtra("name", nameEt.getText());
            startActivity(intent);
        }
    }
}