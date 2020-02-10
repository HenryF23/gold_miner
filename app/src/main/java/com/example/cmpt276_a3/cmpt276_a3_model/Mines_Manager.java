package com.example.cmpt276_a3.cmpt276_a3_model;

import java.util.Arrays;
import java.util.Random;

public class Mines_Manager {
    private static final Mines_Manager ourInstance = new Mines_Manager();
    private int myMines[][];

    public static Mines_Manager getInstance() {
        return ourInstance;
    }

    private Mines_Manager() {
    }

    private void Gererate_Mines(int row, int column, int numberOfMines){
        myMines = new int[row][column];
        Random random = new Random();
        int randomMines = 0;
        int totalGrids = row * column;

        while(numberOfMines > 0){
            randomMines = random.nextInt(totalGrids);
            if(myMines[totalGrids / column][totalGrids % column] != -1){
                myMines[totalGrids / column][totalGrids % column] = -1;
                numberOfMines--;
            }
        }
    }

    // Print 2D array
    public void Display_2D_Array(int mat[][])
    {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
