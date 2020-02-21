package com.example.cmpt276_a3.cmpt276_a3_model;

import android.content.Context;
import android.content.SharedPreferences;

public class Score_Watcher {
    private static final Score_Watcher ourInstance = new Score_Watcher();
    private int maxScoreForGridRow4;
    private int maxScoreForGridRow5;
    private int maxScoreForGridRow6;
    private int numGamesPlayed;
    private final String MAX_SCORE_FOR_GRID_4 = "maxScoreForGrid4";
    private final String MAX_SCORE_FOR_GRID_5 = "maxScoreForGrid5";
    private final String MAX_SCORE_FOR_GRID_6 = "maxScoreForGrid6";
    private final String NUM_GAMES_PLAYED = "numGamesPlayed";

    public static Score_Watcher getInstance(){
        return ourInstance;
    }

    private Score_Watcher(){
        resetAllValues();
    }

    public int getMaxScoreForGridRow4() {
        return maxScoreForGridRow4;
    }

    public int getMaxScoreForGridRow5() {
        return maxScoreForGridRow5;
    }

    public int getMaxScoreForGridRow6() {
        return maxScoreForGridRow6;
    }

    public int getNumGamesPlayed() {
        return numGamesPlayed;
    }

    public void setMaxScoreForGridRow4(int maxScoreForGridRow4) {
        this.maxScoreForGridRow4 = maxScoreForGridRow4;
    }

    public void setMaxScoreForGridRow5(int maxScoreForGridRow5) {
        this.maxScoreForGridRow5 = maxScoreForGridRow5;
    }

    public void setMaxScoreForGridRow6(int maxScoreForGridRow6) {
        this.maxScoreForGridRow6 = maxScoreForGridRow6;
    }

    public void incNumGamesPlayed() {
        this.numGamesPlayed++;
    }

    public void resetAllValues(){
        maxScoreForGridRow4 = Integer.MAX_VALUE;
        maxScoreForGridRow5 = Integer.MAX_VALUE;
        maxScoreForGridRow6 = Integer.MAX_VALUE;
        numGamesPlayed = 0;
    }

    public void saveScore(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("userInfo",
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putInt(MAX_SCORE_FOR_GRID_4, maxScoreForGridRow4);
        editor.putInt(MAX_SCORE_FOR_GRID_5, maxScoreForGridRow5);
        editor.putInt(MAX_SCORE_FOR_GRID_6, maxScoreForGridRow6);
        editor.putInt(NUM_GAMES_PLAYED, numGamesPlayed);
        editor.apply();
    }

    public void getSavedScore(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("userInfo",
                context.MODE_PRIVATE);

        if(sharedPreferences.getInt(MAX_SCORE_FOR_GRID_4, -1) != -1){
            maxScoreForGridRow4 = sharedPreferences.getInt(MAX_SCORE_FOR_GRID_4, -1);
            maxScoreForGridRow5 = sharedPreferences.getInt(MAX_SCORE_FOR_GRID_5, -1);
            maxScoreForGridRow6 = sharedPreferences.getInt(MAX_SCORE_FOR_GRID_6, -1);
            numGamesPlayed = sharedPreferences.getInt(NUM_GAMES_PLAYED, -1);
        }
    }
}
