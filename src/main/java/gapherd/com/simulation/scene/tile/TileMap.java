package gapherd.com.simulation.scene.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

public abstract class TileMap {

    private final int width;
    private final int height;
    private final int amplifier = 3;
    private final TileSet tileSet;

    private final List<Tile> tileList;

    protected TileMap(int width, int height, BufferedImage tileSet) {

        this.width = width;
        this.height = height;
        this.tileSet = new TileSet(width, height, tileSet);

        tileList = this.createTiles();

    }

    public void render(Graphics graphics) {

        this.drawTiles(graphics);

    }

    protected abstract List<Tile> createTiles();

    protected TileSet getTileSet() {
        return tileSet;
    }

    private void drawTiles(Graphics graphics) {

        tileList.forEach(tile -> {

            graphics.drawImage(tile.getTileImg(), tile.getX(), tile.getY(), this.width * amplifier, this.height * amplifier, null);

        });

    };

}
