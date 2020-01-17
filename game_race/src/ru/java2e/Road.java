package ru.java2e;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener{

    Timer mainTimer = new Timer(5, this);

    Image img = new ImageIcon("res/road.png").getImage();

    Player player = new Player();

    Enemy enemy = new Enemy(850, 150, 1, this );

    public Road() {
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            try {
                player.keyPressed(e);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }
    }

    public void paint(Graphics g){
        g = (Graphics2D) g;
        g.drawImage(img, player.layer1, 0, null);
        g.drawImage(img, player.layer2, 0, null);
        g.drawImage(player.img, player.x, player.y, null);
        g.drawImage(enemy.img, enemy.x, enemy.y, null);
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        enemy.move();
        repaint();
    }
}
