package com.example.cmpt276_a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide state bar
        getSupportActionBar().hide();//hide act bar
        setContentView(R.layout.activity_settings);


        Button settingsBackButton = findViewById(R.id.SettingsBackButton);
        settingsBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        RadioGroup boardSize = (RadioGroup) findViewById(R.id.RadioGroupBoard);
        RadioGroup numberMines = (RadioGroup) findViewById(R.id.RadioGroupMines);

        boardSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            // https://www.twle.cn/l/yufei/android/android-basic-radiogroup.html
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "You select: " + radbtn.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        numberMines.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "You select: " + radbtn.getText(), Toast.LENGTH_SHORT).show();
            }
        });





    }
}
