package gapherd.com.render.ui;


import gapherd.com.simulation.input.KeyListenerImpl;

import javax.swing.JFrame;

public class GameWindow {

    private final JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {

        this.jFrame = new JFrame();
        this.jFrame.add(gamePanel);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setLocation(1, 1);
        this.jFrame.setResizable(true);
        this.jFrame.addKeyListener(new KeyListenerImpl());
        this.jFrame.setVisible(true);
        this.jFrame.pack();

    }

    public void repaint() {

        this.jFrame.repaint();

    }

}
