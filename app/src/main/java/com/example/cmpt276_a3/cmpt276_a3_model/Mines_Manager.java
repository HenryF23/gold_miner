package com.example.cmpt276_a3.cmpt276_a3_model;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Mines_Manager {
    private static final Mines_Manager ourInstance = new Mines_Manager();
    private int row;
    private int column;
    private int myMines[][];

    public static Mines_Manager getInstance() {
        return ourInstance;
    }

    public void Generate_Mines(int myRow, int myColumn, int numberOfMines){
        row = myRow;
        column = myColumn;
        myMines = new int[row][column];
        Random random = new Random();
        int randomMines;

        // Initialize all elements of 2D array to 0
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                myMines[i][j] = 0;
            }
        }

        // Random assign mines to the 2D array
        while(numberOfMines > 0){
            randomMines = random.nextInt(row * column);
//            System.out.println(randomMines);
//            System.out.println(randomMines / column + ", " + randomMines % row);
            if(myMines[randomMines / column][randomMines % row] != -1){
                myMines[randomMines / column][randomMines % row] = -1;
                numberOfMines--;
            }
        }

        Scan_Mines();
    }

    // -1 = Mine, -2 = Revealed Mine
    private void Scan_Mines(){
        // Populate number of mines to each non-mine cell
        int count;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                count = 0;

                if(myMines[i][j] >= 0){
                    // Check mines for the corresponding row
                    for(int temp = 0; temp < row; temp++){
                        if (myMines[temp][j] == -1)
                            count++;
                    }

                    // Check mines for the corresponding column
                    for(int temp = 0; temp < column; temp++){
                        if (myMines[i][temp] == -1)
                            count++;
                    }

                    myMines[i][j] = count;
                }
            }
        }
    }

    public void Check_Mine_And_Return_New_Mine(int userRow, int userColumn){
        if(myMines[userRow][userColumn] == -1)
            myMines[userRow][userColumn] = -2;
        Scan_Mines();
    }

    // Print 2D array for debug purpose
    public void Display_2D_Array()
    {
        for (int[] row : myMines)
            System.out.println(Arrays.toString(row));
    }
}
