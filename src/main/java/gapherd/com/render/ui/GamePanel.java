package gapherd.com.render.ui;


import gapherd.com.render.RenderThread;
import gapherd.com.simulation.SimulationThread;
import gapherd.com.simulation.scene.AbstractScene;
import gapherd.com.simulation.scene.RockScene;
import gapherd.com.util.ImageUtils;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.Random;

public class GamePanel extends JPanel {

    public static int x = 600;
    public static int y = 300;

    //TODO - Remove this after finish EntityHolder with player implementation
    private Image img = ImageUtils.loadImage(ImageUtils.ImageType.SPRITE, "player_spr").getSubimage(16, 0, 16, 16);
    private final String screenResolution;
    private AbstractScene scene = new RockScene();

    public GamePanel() {

        Dimension dimension = new Dimension(1280, 720);
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setOpaque(false);

        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        this.screenResolution = graphicsDevice.getDisplayMode().getWidth() + "x" + graphicsDevice.getDisplayMode().getHeight();

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        //TODO - Refactor render calls logic
        scene.render(g);

        g.setColor(new Color(new Random().nextInt()));
        g.drawImage(img, x, y, 48, 48, null);

        g.setColor(new Color(1));

        g.drawString("FPS: " + RenderThread.getFps(), 1, 10);
        g.drawString("TPS: " + SimulationThread.getTps(), 1, 20);
        g.drawString(this.screenResolution, 1, 30);

    }

}
