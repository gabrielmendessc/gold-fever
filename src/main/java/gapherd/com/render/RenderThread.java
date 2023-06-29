package gapherd.com.render;

import gapherd.com.render.ui.GamePanel;
import gapherd.com.render.ui.GameWindow;
import gapherd.com.util.TimeUtils;

public class RenderThread implements Runnable {

    private static final int FRAME_RATE = 0;
    private static final double FRAME_TIME = ((double) TimeUtils.toNanoSeconds(1)) / FRAME_RATE;

    private static int FPS = 0;
    private static int FRAMES = 0;

    private final GameWindow gameWindow;

    public RenderThread() {

        gameWindow = new GameWindow(new GamePanel());

        new Thread(this::checkFpsLoop).start();

    }

    @Override
    public void run() {

        double lastFrameTime = System.nanoTime();
        double elapsedFrameTime = 0;

        while (true) {

            long currenteFrameTime = System.nanoTime();

            if (FRAME_RATE > 0) {

                elapsedFrameTime += calculateElapsedFrameTime(lastFrameTime, currenteFrameTime);
                lastFrameTime = currenteFrameTime;

                if (elapsedFrameTime >= 1) {

                    render();

                    elapsedFrameTime--;

                }

            } else {

                render();

            }

        }

    }

    public static int getFps() {

        return FPS;

    }

    public void checkFpsLoop() {

        double lastCheckTime = System.nanoTime();

        while (true) {

            if (hasOneSecondElapsed(lastCheckTime)) {

                FPS = FRAMES;
                FRAMES = 0;
                lastCheckTime = System.nanoTime();

            }

        }

    }

    private void render() {

        FRAMES++;

        this.gameWindow.repaint();

    }

    private static double calculateElapsedFrameTime(double lastFrameTime, long currentFrameTime) {

        return (currentFrameTime - lastFrameTime) / RenderThread.FRAME_TIME;

    }

    private static boolean hasOneSecondElapsed(double lastCheckTime) {

        return System.nanoTime() - lastCheckTime >= TimeUtils.toNanoSeconds(1);

    }

}
