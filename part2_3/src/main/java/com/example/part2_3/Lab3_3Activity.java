package com.example.part2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Lab3_3Activity extends AppCompatActivity implements View.OnClickListener {

    Button trueBtn;
    TextView targetTextView;
    Button falseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_3);

        //View 객체 획득
        trueBtn = findViewById(R.id.btn_visible_true);
        targetTextView = findViewById(R.id.text_visible_target);
        falseBtn = findViewById(R.id.btn_visible_false);

        //Button 이벤트 등록
        trueBtn.setOnClickListener(this);
        falseBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == trueBtn) {
            //trueBtn 이 눌리면 targetTextView 를 visible 상태로 변경
            targetTextView.setVisibility(View.VISIBLE);
        } else if(v == falseBtn) {
            //falseBtn 이 눌리면 targetTextView 를 invisible 상태로 변경
            targetTextView.setVisibility(View.INVISIBLE);
        }
    }
}