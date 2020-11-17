package com.example.part2_7;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.img);
        //애니메이션 획득
        Animation anim  = AnimationUtils.loadAnimation(this, R.anim.in);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
                //마지막 상황에서 멈추도록, 안 그러면 원상 복귀
                anim.setFillAfter(true);
                imageView.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        //애니메이션 시작
        /*퍼센트 뒤에 p 를 붙이면 뷰를 소유한 부모 객체의 너비에서 퍼센트를 연산한 위치에서 시작하게 됩니다.*/
        imageView.startAnimation(anim);
    }
}