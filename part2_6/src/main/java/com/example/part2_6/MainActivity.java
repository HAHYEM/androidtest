package com.example.part2_6;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    TextView bellTextView;
    TextView labelTextView;
    TextView alarmTextView;

    CheckBox repeatCheckView;
    CheckBox vibrateCheckView;

    Switch switchView;

    float initX;
    long initTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bellTextView = findViewById(R.id.bell_name);
        labelTextView = findViewById(R.id.label);
        alarmTextView = findViewById(R.id.time);

        repeatCheckView = findViewById(R.id.repeatCheck);
        vibrateCheckView = findViewById(R.id.vibrate);
        switchView = findViewById(R.id.onOff);

        bellTextView.setOnClickListener(this);
        labelTextView.setOnClickListener(this);
        alarmTextView.setOnClickListener(this);

        repeatCheckView.setOnCheckedChangeListener(this);
        vibrateCheckView.setOnCheckedChangeListener(this);
        switchView.setOnCheckedChangeListener(this);
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        if(v == bellTextView) {
            showToast("helium bell text click event.");
        } else if (v == labelTextView) {
            showToast("label text click event.");
        } else if (v == alarmTextView) {
            //현재 시간으로 Dialog를 띄우기 위해 시간을 구함
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    showToast(hourOfDay + " : " + minute);
                }
            }, hour, minute, false);
            timeDialog.show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView == repeatCheckView) {
            showToast("repeat checkbox is " + isChecked);
        } else if (buttonView == vibrateCheckView) {
            showToast("vibrate checkbox is " + isChecked);
        } else if (buttonView == switchView) {
            showToast("switch is " + isChecked);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            initX = event.getRawX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            float diff_x = initX - event.getRawX();
            if(diff_x > 30) {
                showToast("왼쪽으로 화면을 밀었습니다.");
            } else if(diff_x < -30) {
                showToast("오른쪽으로 화면을 밀었습니다.");
            }
        }
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(System.currentTimeMillis() - initTime > 3000) {
                //back button 을 누른 지 3초가 지난 것이라면..
                showToast("종료하려면 한 번 더 누르세요");
                //현재 시간 저장
                initTime = System.currentTimeMillis();
            } else {
                //3초 이내에 Back button이 두 번 눌린 경우, Activity End
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
