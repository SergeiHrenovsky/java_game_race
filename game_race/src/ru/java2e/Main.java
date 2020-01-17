package ru.java2e;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame f = new JFrame("java game race");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 511);
        f.add(new Road());
        f.setVisible(true);
    }
}
