package gapherd.com.simulation.scene.tile;

import gapherd.com.util.ImageUtils;

import java.util.ArrayList;
import java.util.List;

public class RockTileMap extends TileMap {

    public RockTileMap() {

        super(16, 16, ImageUtils.loadImage(ImageUtils.ImageType.TILESET, "rock_set"));

    }

    @Override
    protected List<Tile> createTiles() {

        List<Tile> tileList = new ArrayList<>();

        int x = 0, y = 672;
        for (int i =0; i < 27; i++) {

            tileList.add(getTileSet().getTile(0).from(x, y));

            x += 48;

        }

        return tileList;

    }

}
