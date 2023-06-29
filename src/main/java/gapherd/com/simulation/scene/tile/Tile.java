package gapherd.com.simulation.scene.tile;

import java.awt.image.BufferedImage;

public class Tile {

    private int x;
    private int y;
    private BufferedImage tileImg;

    public Tile(int x, int y, BufferedImage tileImg) {
        this.x = x;
        this.y = y;
        this.tileImg = tileImg;
    }

    public Tile from(int x, int y) {

        return new Tile(x, y, this.tileImg);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getTileImg() {
        return tileImg;
    }
}
