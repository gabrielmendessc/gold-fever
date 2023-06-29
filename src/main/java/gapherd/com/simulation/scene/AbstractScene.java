package gapherd.com.simulation.scene;

import gapherd.com.simulation.entity.EntityHolder;
import gapherd.com.simulation.scene.tile.TileMap;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractScene {

    private final List<EntityHolder> entityList = new ArrayList<>();
    private TileMap tileMap;

    public AbstractScene(TileMap tileMap) {
        this.tileMap = tileMap;
    }

    public void tick() {

        this.entityList.forEach(EntityHolder::tick);

    }

    public void render(Graphics g) {

        this.tileMap.render(g);

    }



    public void addEntity(EntityHolder entityHolder) {

        entityList.add(entityHolder);

    }

}
