package com.example.part2_4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //현재시간을 msec으로 구한다.
    long now = System.currentTimeMillis();
    //현재시간을 date 변수에 저장한다.
    Date date = new Date(now);
    //시간을 나타낼 포맷을 정한다(yyyy/MM/dd같은 형태)
    SimpleDateFormat sdfNow = new SimpleDateFormat("yy.MM.dd");
    //nowDate 변수에 값을 저장한다.
    String formatDate = sdfNow.format(date);

    TextView dateNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateNow = (TextView) findViewById(R.id.dateNow);
        dateNow.setText(formatDate); //TextView에 현재 시간 문자열 할당
    }
}