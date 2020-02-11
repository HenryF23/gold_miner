package com.example.cmpt276_a3.cmpt276_a3_model;

class Mines_ManagerTest {
    Mines_Manager mines_manager = Mines_Manager.getInstance();

    @org.junit.jupiter.api.Test
    void display2DArrayTest(){
        mines_manager.setMineProperties(5, 5, 6);
        mines_manager.generateNewMines();

        mines_manager.display2DArray();
        System.out.println("----------------------------------------------");
        mines_manager.checkMineAndReturnNewMine(3,1);
        mines_manager.display2DArray();
    }

//    @org.junit.jupiter.api.Test
//    void getInstance() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void generate_Mines() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void display_2D_Array() {
//    }
}