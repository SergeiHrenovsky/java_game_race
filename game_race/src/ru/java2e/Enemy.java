package ru.java2e;

import java.awt.Image;
import javax.swing.*;

public class Enemy {
    int speed;
    int x;
    int y;
    Image img = new ImageIcon("res/car_enemy_forward.png").getImage();
    Road road;

    public Enemy(int x, int y, int speed, Road road){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.road = road;
    }

    public void move(){
        x = x - road.player.speed + speed;
    }
}
