package com.example.cmpt276_a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    private TextView HyperLink;

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

        HyperLink = (TextView) findViewById(R.id.LinkTextView);

        Spanned Text = Html.fromHtml("Click on this link to visit course Website <br />" +
                "<a href='http://opencoursehub.cs.sfu.ca/bfraser/grav-cms/cmpt276/home'>Course Website</a>");

        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Text);


    }
}
