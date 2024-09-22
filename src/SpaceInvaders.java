import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SpaceInvaders extends JPanel implements ActionListener {
    class Block {
        int x;
        int y;
        int width;
        int height;
        Image img;
        boolean alive = true; //used for aliens
        boolean used = false; //used for bullets

        Block(int x, int y, int width, int height, Image img) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.img = img;
        }
    }
    //Board
    int tileSize = 32;
    int rows = 16;
    int columns = 16;
    int boardWidth = tileSize * columns; //32*16 = 512px
    int boardHeight = tileSize * rows; //32*16 = 512px

    Image shipImg;
    Image alienImg;
    Image alienCyanImg;
    Image alienMagentaImg;
    Image alienYellowImg;
    ArrayList<Image> alienImgArray;

    //Ship
    int shipWidth = tileSize*2; //64px
    int shipHeight = tileSize; //32px
    int shipX = tileSize*columns/2 - tileSize;
    int shipY = boardHeight - tileSize*2;

    Block ship;

    Timer gameLoop;

    SpaceInvaders() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);

        //Load Images
        shipImg = new ImageIcon(getClass().getResource("./ship.png")).getImage();
        alienImg = new ImageIcon(getClass().getResource("./alien.png")).getImage();
        alienCyanImg = new ImageIcon(getClass().getResource("./alien-cyan.png")).getImage();
        alienMagentaImg = new ImageIcon(getClass().getResource("./alien-magenta.png")).getImage();
        alienYellowImg = new ImageIcon(getClass().getResource("./alien-yellow.png")).getImage();

        alienImgArray = new ArrayList<Image>();
        alienImgArray.add(alienImg);
        alienImgArray.add(alienCyanImg);
        alienImgArray.add(alienMagentaImg);
        alienImgArray.add(alienYellowImg);

        ship = new Block(shipX, shipY, shipWidth, shipHeight, shipImg);

        //Game Timer
        gameLoop = new Timer(1000/60, this); //1000/60 = 16.6
        gameLoop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //Ship
        g.drawImage(ship.img, ship.x, ship.y, ship.width, ship.height, null);

        //Aliens
    }
}
