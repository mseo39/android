package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import android.os.CountDownTimer;

public class Guess_num extends AppCompatActivity {
    
    //============== 난수 발생
    Random random = new Random(); // 랜덤 객체 생성
    private int random_num= random.nextInt(100)+1; //1~100 정수 중 랜덤으로 저장

    //============== 시도할 수 있는 기회
    private int try_num=5; //5로 초기화 //참고로 점수는 try_num*20이다
    
    //============== 카운트다운
    private int count=30; //타이머 변수를 30으로 초기화
    private TextView time_text; //time_text TextView를 저장할 변수 선언
    private CountDownTimer countDownTimer; //CountDownTimer를 저장할 변수 선언

    //============= 레이아웃 생성, 초기화 컴포넌트를 불러옴
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //프로그램 Activity가 생성할 때 실행
        setContentView(R.layout.activity_main); //화면 디자인을 xml로 정의해놓은 파일을 불러와 지정

        //textView에서 id가 time_text인 것을 가져와서 저장함
        time_text = (TextView)findViewById(R.id.time_text);
        //Timer함수 호출
        Timer();
        //카운트다운 시작
        countDownTimer.start();
    }

    public void Timer(){

        //CountDownTimer 객체 생성, 매개변수는 총 시간, 시간 간격이다
        countDownTimer = new CountDownTimer(30*1000, 1000) {
            //1초에 한번씩 실행됨(매개변수로 1000을 보냈기 때문)
            public void onTick(long millisUntilFinished) {
                //time_text에 count로 지정_ 여기서 문자열로 바꾸지 않으면 오류가 발생한다. 유의하자
                time_text.setText(String.valueOf(count));
                //count 값을 1 줄이자
                count --;
            }//마지막에 실행되는 메소드이다
            public void onFinish() {
                time_text.setText(String.valueOf("Finish ."));
            }
        };
    }

    //countdowntimer는 현재 스레드의 상태를 확인하는 부분이 없기 때문에
    //카운트다운이 돌아가지 않는데 cancel()을 하면 에러가 나는 상황이 발생하기 때문에
    //에러가 발생하면 countdowntimer를 초기화하는 방식으로 해결이 가능함
    @Override
    public void onDestroy() {
        super.onDestroy();
        try{
            countDownTimer.cancel();
        } catch (Exception e) {}
        countDownTimer=null;
    }
    
    //============= guess 버튼을 클릭했을 때
    public void Clickbutton(View view){

        EditText et; //editText 변수 선언, 사용자로 부터 입력 받는 위젯
        et = (EditText)findViewById(R.id.edit_num); //editText에서 id가 edit_num인 것을 찾아서 변수에 저장

        TextView guess_text; //Textview 변수 선언 , 입력받은 값에 따라 문구를 바꾸는 위젯
        guess_text = (TextView)findViewById(R.id.guess_text); //textView에서 id가 guess_text인 것을 찾아서 변수에 저장
        
        //=====사용자의 입력값이 공백인지 검사

        //만약 사용자의 입력값이 공백이라면
        if (et.getText().toString().length()==0){
            guess_text.setText("입력값이 없습니다");
        }
        else{ //사용자로부터 받은 입력값이 공백이 아니라면
            //사용자로부터 입력 받은 값을 가져와 -> 문자열로 변경 -> 정수로 변경하여 num 변수에 저장
            int num = Integer.parseInt((et.getText().toString()));
            
            // =====난수와 사용자로부터 입려받은 값을 비교

            if (num == random_num) { //같다
                guess_text.setText("정답입니다");
                countDownTimer.cancel();
            }else if (num<random_num){ //random 숫자가 입력한 수보다 크면
                guess_text.setText("UP");
            }else{
                guess_text.setText("DOWN");
            }
        }
        
        //============== 시도 횟수 변경

        //버튼을 눌렀다는 것은 숫자 추측을 시도했다는 것으로 try_num을 -1 해준다
        try_num=try_num-1;
        TextView try_text = (TextView)findViewById(R.id.try_text); //try_text변수를 선언하여 textView에서 id가 try_text인 것을 찾아서 변수에 저장

        if (try_num<=0){ //만약 시도가 더이상 없다면
            guess_text.setText("GAME OVER");//gameover
            countDownTimer.cancel();
        }else {//시도 횟수가 남았다면
            try_text.setText("기회: " + try_num); //시도 횟수로 텍스트 지정
        }
    }
}