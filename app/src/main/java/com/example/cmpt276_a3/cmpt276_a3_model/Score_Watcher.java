package com.example.cmpt276_a3.cmpt276_a3_model;

public class Score_Watcher {
    private static final Score_Watcher ourInstance = new Score_Watcher();
    private int maxScoreForGridRow4;
    private int maxScoreForGridRow5;
    private int maxScoreForGridRow6;
    private int numGamesPlayed;

    public static Score_Watcher getInstance(){
        return ourInstance;
    }

    public Score_Watcher(){
        maxScoreForGridRow4 = 0;
        maxScoreForGridRow5 = 0;
        maxScoreForGridRow6 = 0;
        numGamesPlayed = 0;
    }

    public int getMaxScoreForGridRow4() {
        return maxScoreForGridRow4;
    }

    public void setMaxScoreForGridRow4(int maxScoreForGridRow4) {
        this.maxScoreForGridRow4 = maxScoreForGridRow4;
    }

    public int getMaxScoreForGridRow5() {
        return maxScoreForGridRow5;
    }

    public void setMaxScoreForGridRow5(int maxScoreForGridRow5) {
        this.maxScoreForGridRow5 = maxScoreForGridRow5;
    }

    public int getMaxScoreForGridRow6() {
        return maxScoreForGridRow6;
    }

    public void setMaxScoreForGridRow6(int maxScoreForGridRow6) {
        this.maxScoreForGridRow6 = maxScoreForGridRow6;
    }

    public int getNumGamesPlayed() {
        return numGamesPlayed;
    }

    public void setNumGamesPlayed(int numGamesPlayed) {
        this.numGamesPlayed = numGamesPlayed;
    }

    public void updateScore(){

    }
}
