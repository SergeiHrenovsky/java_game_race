package ru.java2e;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Player{
    public static final int MAX_SPEED = 500;
    public static final int MIN_SPEED = 0;
    public static final int MAX_TOP = 130;
    public static final int MAX_BOTTOM = 285;

    Image img = new ImageIcon("res/car_straight.png").getImage();

    int speed = 1;
    int speed_up;
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
        if (speed >= MAX_SPEED) speed = MAX_SPEED;
        if (speed <= MIN_SPEED) speed = MIN_SPEED;
        if (y <= MAX_TOP) y = MAX_TOP;
        if (y >= MAX_BOTTOM) y = MAX_BOTTOM;
        y -= move_up_down;
        distance += speed;
        move_up_down = 0;
    }

    public void keyPressed(KeyEvent e) throws InterruptedException {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            speed_up = 1;
            TimeUnit.MILLISECONDS.sleep(200);
        }
        if (key == KeyEvent.VK_LEFT) {
            speed_up = -1;
            TimeUnit.MILLISECONDS.sleep(200);
        }
        if (key == KeyEvent.VK_UP && y > MAX_TOP) {
            move_up_down = 10;
        }
        if (key == KeyEvent.VK_DOWN && y < MAX_BOTTOM) {
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
