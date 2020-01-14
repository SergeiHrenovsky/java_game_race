package ru.java2e;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player{
    Image img = new ImageIcon("res/car_straight.png").getImage();

    int speed = 1;
    int speed_up = 0;
    int move_up_down = 0;
    int distance = 0;

    int layer1 = 0;
    int layer2 = 1023;

    int x = 50;
    int y = 130;

    public void move(){
        if (layer2 - speed <= 0) {
            layer1 = 0;
            layer2 = 1023;
        } else {
            layer1 -= speed;
            layer2 -= speed;
        }
        speed += speed_up;
        y -= move_up_down;
        distance += speed;
        move_up_down = 0;
    }


    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            speed_up = 1;
        }
        if (key == KeyEvent.VK_LEFT) {
            speed_up = -1;
        }
        if (key == KeyEvent.VK_UP && y > 130) {
            move_up_down = 10;
        }
        if (key == KeyEvent.VK_DOWN && y < 285) {
            move_up_down = -10;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT){
            speed_up = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
            move_up_down = 0;
        }
    }
}
