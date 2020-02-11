package com.example.cmpt276_a3.cmpt276_a3_model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class Mines_ManagerTest {
    Mines_Manager mines_manager = Mines_Manager.getInstance();

    @org.junit.jupiter.api.Test
    void display2DArrayTest(){
        mines_manager.Generate_Mines(5, 5, 6);

        mines_manager.Display_2D_Array();
        System.out.println("---------------------------------------------");
        mines_manager.Check_Mine_And_Return_New_Mine(3,1);
        mines_manager.Display_2D_Array();
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