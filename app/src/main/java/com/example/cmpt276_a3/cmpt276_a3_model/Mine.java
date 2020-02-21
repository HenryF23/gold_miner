package com.example.cmpt276_a3.cmpt276_a3_model;

public class Mine {
    public int value;
    public boolean revealed;

    public void Mine(){
        value = 0;
        revealed = false;
    }

    @Override
    public String toString() {
        return "[" + value + "," + revealed + "]";
    }
}
