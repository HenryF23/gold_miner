package com.example.cmpt276_a3.cmpt276_a3_model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * This class stores and get the game stats from files
 * It will also save game status in the file so the data won't lost
 */
public class Score_Watcher {
    private static final Score_Watcher ourInstance = new Score_Watcher();
    private int numGamesPlayed;
    private String tagName;
    private final String NUM_GAMES_PLAYED = "numGamesPlayed";
    private final int row = 3;
    private final int column = 4;
    private int scores[][];
//    private int maxScoreForGridRow4Gold6;
//    private int maxScoreForGridRow4Gold10;
//    private int maxScoreForGridRow4Gold15;
//    private int maxScoreForGridRow4Gold20;
//    private int maxScoreForGridRow5Gold6;
//    private int maxScoreForGridRow5Gold10;
//    private int maxScoreForGridRow5Gold15;
//    private int maxScoreForGridRow5Gold20;
//    private int maxScoreForGridRow6Gold6;
//    private int maxScoreForGridRow6Gold10;
//    private int maxScoreForGridRow6Gold15;
//    private int maxScoreForGridRow6Gold20;

//    private final String MAX_SCORE_FOR_GRID_4 = "maxScoreForGrid4";
//    private final String MAX_SCORE_FOR_GRID_5 = "maxScoreForGrid5";
//    private final String MAX_SCORE_FOR_GRID_6 = "maxScoreForGrid6";
//
//
//    private final String maxScoreForGridRow4Gold6 = "maxScoreForGridRow4Gold6";
//    private final String maxScoreForGridRow4Gold10 = "maxScoreForGridRow4Gold10";
//    private final String maxScoreForGridRow4Gold15 = "maxScoreForGridRow4Gold15";
//    private final String maxScoreForGridRow4Gold20 = ;
//    private final String maxScoreForGridRow5Gold6 = ;
//    private final String maxScoreForGridRow5Gold10 = ;
//    private final String maxScoreForGridRow5Gold15 = ;
//    private final String maxScoreForGridRow5Gold20 = ;
//    private final String maxScoreForGridRow6Gold6 = ;
//    private final String maxScoreForGridRow6Gold10 = ;
//    private final String maxScoreForGridRow6Gold15 = ;
//    private final String maxScoreForGridRow6Gold20 = ;

    public static Score_Watcher getInstance(){
        return ourInstance;
    }

    private Score_Watcher(){
        scores = new int[row][column];
        resetAllValues();
    }

    public int getMaxScore(int userRow, int userColumn) {
        return scores[userRow][userColumn];
    }


    public int getNumGamesPlayed() {
        return numGamesPlayed;
    }

    public void setMaxScore(int userRow, int userColumn, int score) {
        scores[userRow][userColumn] = score;
    }

    public void incNumGamesPlayed() {
        this.numGamesPlayed++;
    }

    public void resetAllValues(){
        numGamesPlayed = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                scores[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void saveScore(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("userInfo",
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                tagName = "" + i + j;
                Log.i("Save", tagName);
                editor.putInt(tagName, scores[i][j]);
            }
        }

        editor.putInt(NUM_GAMES_PLAYED, numGamesPlayed);
        editor.apply();
    }

    public void getSavedScore(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("userInfo",
                context.MODE_PRIVATE);

        if(sharedPreferences.getInt("00", -1) != -1){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    tagName = "" + i + j;
                    Log.i("Get", tagName);
                    scores[i][j] = sharedPreferences.getInt(tagName, -1);
                }
            }
            numGamesPlayed = sharedPreferences.getInt(NUM_GAMES_PLAYED, -1);
        }
    }
}
