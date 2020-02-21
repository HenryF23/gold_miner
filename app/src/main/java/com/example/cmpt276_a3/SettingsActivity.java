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

import com.example.cmpt276_a3.cmpt276_a3_model.Mines_Manager;

import java.lang.reflect.Type;


public class SettingsActivity extends AppCompatActivity {
    Mines_Manager mines_manager;

    int NumberRow = 4;
    int NumberCol = 6;
    int NumberMines = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide state bar
        getSupportActionBar().hide();//hide act bar
        setContentView(R.layout.activity_settings);

        mines_manager = Mines_Manager.getInstance();
        NumberRow = mines_manager.getRow();
        NumberCol = mines_manager.getColumn();
        NumberMines = mines_manager.getNumberOfMines();



        RadioGroup boardSize = findViewById(R.id.RadioGroupBoard);
        RadioGroup numberMines = findViewById(R.id.RadioGroupMines);

        boardSize.check(R.id.radioButton4x6);
        numberMines.check(R.id.mines6);


        Button settingsBackButton = findViewById(R.id.SettingsBackButton);
        settingsBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        boardSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            // https://www.twle.cn/l/yufei/android/android-basic-radiogroup.html
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn1 = findViewById(checkedId);

                String a = (radbtn1.getText()).charAt(0) + "";
                NumberRow = Integer.parseInt(a);

                if (NumberRow == 4)
                {
                    NumberCol = 6;
                }
                else if (NumberRow == 5)
                {
                    NumberCol = 10;
                }
                else {
                    NumberCol = 15;
                }

//                Toast.makeText(getApplicationContext(), "You select: " + radbtn1.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        numberMines.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn2 = findViewById(checkedId);
                System.out.println(radbtn2.getText());

//                String a = (radbtn2.getText()).charAt(0) + "";
//                NumberMines = Integer.parseInt(a);

                String a = radbtn2.getText().toString();
//                String ai = a.replaceAll("\\D+","");
//                System.out.println(ai);

                if (a.equals("6 mines")){
                    NumberMines = 6;
                }
                else if(a.equals("10 mines")){
                    System.out.println("yes its 10");
                    NumberMines = 10;
                }
                else if (a.equals("15 mines")){
                    System.out.println("yes its 15");

                    NumberMines = 15;
                }
                else if (a.equals("20 mines")){
                    NumberMines = 20;
                }


//                Toast.makeText(getApplicationContext(), "You select: " + radbtn2.getText(), Toast.LENGTH_SHORT).show();
            }
        });


        Button settingsSaveButton = findViewById(R.id.SettingsSavebutton);

        switch(NumberRow) {
            case 4:
                boardSize.check(R.id.radioButton4x6);
                break;
            case 5:
                boardSize.check(R.id.radioButton5x10);

                break;
            case 6:
                boardSize.check(R.id.radioButton6x15);
                break;
        }
//
        switch(NumberMines) {
            case 10:
                numberMines.check(R.id.mines10);
                break;
            case 15:
                numberMines.check(R.id.mines15);
                break;
            case 20:
                numberMines.check(R.id.mines20);
                break;
            case 6:
                numberMines.check(R.id.mines6);
                break;
        }
        settingsSaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mines_manager.setMineProperties(NumberRow, NumberCol, NumberMines);
                finish();
            }
        });



    }
}
