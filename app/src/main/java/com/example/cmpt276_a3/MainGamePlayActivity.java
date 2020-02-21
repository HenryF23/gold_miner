package com.example.cmpt276_a3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.cmpt276_a3.cmpt276_a3_model.Mines_Manager;


/*
    Gold
    https://www.mining-technology.com/wp-content/
    uploads/sites/8/2019/10/b5.1024_0_1-e1570195581925.jpg

    Lots of gold
    https://encrypted-tbn0.gstatic.com/images?q=tbn%
    3AANd9GcSWNHz_vIAdCBDdEtuurSMy7w35iNFvgcLGs2RwNf1ZqwBiuSQE
 */

public class MainGamePlayActivity extends AppCompatActivity {
    private static int numRows;
    private static int numCols;
    Button buttons[][];
    Mines_Manager myMinesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gameplay);

        myMinesManager = Mines_Manager.getInstance();
        numRows = myMinesManager.getRow();
        numCols = myMinesManager.getColumn();
        buttons = new Button[numRows][numCols];
        myMinesManager.generateNewMines();

        populateMines();
        updateTextViewInfo();
    }

    private void updateTextViewInfo() {
        TextView textView = findViewById(R.id.numMinesFound_textView);
        textView.setText("Found " + myMinesManager.getNumberOfMinesFound()
                + " of " + myMinesManager.getNumberOfMines() + " Mines");

        textView = findViewById(R.id.scanUsed_textView);
        textView.setText("# Scans used: " + myMinesManager.getNumberOfScans());
    }

    private void setDefaultImageToAllButtons(int row, int col, int drawableID){
                Button myButton = buttons[row][col];
                int newWidth = myButton.getWidth();
                int newHeight = myButton.getHeight();

                Bitmap originalBitMap = BitmapFactory.decodeResource(
                        getResources(), drawableID);
                Bitmap scaledBitMap = Bitmap.createScaledBitmap(
                        originalBitMap, newWidth, newHeight, true);
                Resources resource = getResources();

                myButton.setBackground(new BitmapDrawable(resource, scaledBitMap));
    }

    private void lockButtonSizes() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Button button = buttons[row][col];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }

    private void populateMines() {
        TableLayout tableLayout = findViewById(R.id.mine2DTable);

        for(int row = 0; row < numRows; row++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            tableLayout.addView(tableRow);

            for(int col = 0; col < numCols; col++){
                final int FINAL_ROW = row;
                final int FINAL_COL = col;

                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));
                button.setPadding(0, 0, 0, 0);

                if(myMinesManager.isGold(row, col)){
                    button.setSoundEffectsEnabled(false);
                }
                final MediaPlayer mediaPlayer = MediaPlayer.
                        create(this, R.raw.gold_sound);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myMinesManager.isGold(FINAL_ROW, FINAL_COL))
                            mediaPlayer.start();
                        gridButtonClicked(FINAL_ROW, FINAL_COL);
                    }
                });

                tableRow.addView(button);
                buttons[row][col] = button;
            }
        }

        lockButtonSizes();
    }

    private void gridButtonClicked(int tempRow, int tempCol){
        // myMinesManager.updateMine(tempRow, tempCol);
        if(!myMinesManager.isRevealed(tempRow, tempCol)){
            myMinesManager.updateMine(tempRow, tempCol);
            updateAllButtons();
            updateTextViewInfo();

            if(myMinesManager.getNumberOfMinesFound() == myMinesManager.getNumberOfMines()){
                FragmentManager manager = getSupportFragmentManager();
                CongratulationsFragment congratulationsFragment = new CongratulationsFragment();
                congratulationsFragment.show(manager, "CongratulationsDialog");
            }
        }
    }

    private void updateAllButtons(){
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols ;j++){
                if(myMinesManager.isRevealed(i, j)){
                    Button button = buttons[i][j];

                    if(myMinesManager.isGold(i, j)){
//                        button.setBackgroundColor(Color.TRANSPARENT);
//                        button.setText("Mines Found!");
                        lockButtonSizes();
                        setDefaultImageToAllButtons(i, j, R.drawable.gold);
                    }
                    else{
                        button.setBackgroundColor(Color.TRANSPARENT);
                        button.setText("" + myMinesManager.getValueForNonGoldCell(i, j));
                    }
                }
            }
        }
    }

    public static Intent makeIntentForMainGameActivity(Context context){
        return new Intent(context, MainGamePlayActivity.class);
    }

}
