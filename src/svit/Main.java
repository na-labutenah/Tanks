package svit;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel{

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    //1 - Up, 2 - Down, 3 - Left, 4 - Right
    int direction = 1;

    int bulletX = 320;
    int bulletY = 320;

    int x = 256;
    int y = 256;

    void move(int direction) throws InterruptedException {
        this.direction = direction;

        if(direction == 1){
            y--;
        } else if (direction == 2){
            y++;
        } else if (direction == 3){
            x--;
        } else if (direction == 4){
            x++;
        }
        Thread.sleep(33);
        repaint();
    }

    void runTheGame() throws InterruptedException {
        while (y != BF_HEIGHT - 64){
            move(2);
        }
    }

    void moveUp() throws InterruptedException {
        direction = 1;

        while (y != 0){
            y--;
            Thread.sleep(33);
            repaint();
        }
    }

    void moveLeft() throws InterruptedException {
        direction = 3;

        while (x != 0){
            x--;
            Thread.sleep(33);
            repaint();
        }
    }

    void moveDown() throws InterruptedException {
        direction = 2;

        while (y != BF_HEIGHT - 64){
            y++;
            Thread.sleep(33);
            repaint();
        }
    }

    void moveRight() throws InterruptedException {
        direction = 4;

        while (x != BF_WIDTH - 64){
            x++;
            Thread.sleep(33);
            repaint();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        //main.moveRight();
        main.runTheGame();
    }

    Main(){
        JFrame frame = new JFrame("Tanks");
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 36));
        frame.getContentPane().add(this);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 64, 64);

        g.setColor(Color.BLUE);
        switch (direction){
            case 1:
                g.fillRect(x + 20, y, 24, 34);
                break;
            case 2:
                g.fillRect(x + 20, y + 30, 24, 34);
                break;
            case 3:
                g.fillRect(x, y + 20, 34, 24);
                break;
            case 4:
                g.fillRect(x + 30, y + 20, 34, 24);
        }

        g.setColor(Color.GREEN);
        g.fillRect(bulletX, bulletY, 14, 14);
    }
}
