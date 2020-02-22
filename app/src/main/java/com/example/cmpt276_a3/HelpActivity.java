package com.example.cmpt276_a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

/*
This class is about the game's help interface, including game introduction and production staff, and resource sources.
*/
public class HelpActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide state bar
        getSupportActionBar().hide();//hide act bar
        setContentView(R.layout.activity_help);

        Button helpBackButton = findViewById(R.id.helpBackButton);
        helpBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        HyperLink1 = findViewById(R.id.LinkTextView1);
//
//        Spanned courseText = Html.fromHtml("Click on this link to visit course Website <br />" +
//                "<a href='http://opencoursehub.cs.sfu.ca/bfraser/grav-cms/cmpt276/home'>Course Website</a>");
//
//        HyperLink1.setMovementMethod(LinkMovementMethod.getInstance());
//        HyperLink1.setText(courseText);
//
//
//
//        HyperLink2 = findViewById(R.id.LinkTextView2);
//        Spanned lostText = Html.fromHtml("Click on this link to visit course Website <br />" +
//                "<a href='http://www.google.com'>谷歌</a>");
//        HyperLink2.setMovementMethod(LinkMovementMethod.getInstance());
//        HyperLink2.setText(lostText);


        TextView textView = findViewById(R.id.gameInfo_Textview);
        textView.setText(Html.fromHtml(getString(R.string.gameDescription)));
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        TextView textView2 = findViewById(R.id.Ref_TextView);
        textView2.setText(Html.fromHtml(getString(R.string.referenceTextBox)));
        textView2.setMovementMethod(LinkMovementMethod.getInstance());



    }
}
