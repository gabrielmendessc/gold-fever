package gapherd.com.simulation.scene.tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TileSet {

    private final int width;
    private final int height;
    private final List<Tile> tileList;
    private final BufferedImage tileSetImage;

    public TileSet(int width, int height, BufferedImage tileSetImage) {

        this.width = width;
        this.height = height;
        this.tileSetImage = tileSetImage;

        this.tileList = cropTiles(tileSetImage);

    }

    private List<Tile> cropTiles(BufferedImage tileSetImage) {

        validateBondaries(tileSetImage);

        List<Tile> tileList = new ArrayList<>();
        int x = 0;
        int y = 0;

        while (y < this.width) {

            while (x < this.width) {

                BufferedImage tileImg = tileSetImage.getSubimage(x, y, this.width, this.height);

                tileList.add(new Tile(x, y, tileImg));

                x += this.width;

            }

            x = 0;
            y += this.height;

        }

        return tileList;

    }

    private void validateBondaries(BufferedImage tileSetImage) {

        if ((tileSetImage.getWidth() % this.width) > 0 ||
            tileSetImage.getHeight() % this.height > 0) {

            throw new RuntimeException("Invalid bondaries");

        }

    }

    public Tile getTile(int tileIndex) {

        if (tileIndex >= getTileList().size()) {

            return null;

        }

        return getTileList().get(tileIndex);

    }

    public List<Tile> getTileList() {

        return tileList;

    }

}
