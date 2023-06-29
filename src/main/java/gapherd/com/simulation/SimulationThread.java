package gapherd.com.simulation;

import gapherd.com.render.ui.GamePanel;
import gapherd.com.simulation.input.KeyTicker;
import gapherd.com.util.KeyUtils;
import gapherd.com.util.TimeUtils;

import java.awt.event.KeyEvent;

public class SimulationThread implements Runnable {

    private static final int TICK_RATE = 60;
    private static final double TICK_TIME = ((double) TimeUtils.toNanoSeconds(1)) / TICK_RATE;

    private static int TPS = 0;
    private static int TICKS = 0;

    public SimulationThread() {

        new Thread(this::checkTps).start();

    }

    @Override
    public void run() {

        double lastTickTime = System.nanoTime();
        double elapsedTickTime = 0;

        while (true) {

            long currentTickTime = System.nanoTime();

            elapsedTickTime += calculateElapsedTickTime(lastTickTime, currentTickTime);
            lastTickTime = currentTickTime;

            if (elapsedTickTime >= 1) {

                if (elapsedTickTime > 2) {

                    System.out.println("Ficou pra tras: " + elapsedTickTime);

                }

                tick();

                elapsedTickTime--;

            }

        }

    }

    private static void tick() {

        TICKS++;

        KeyTicker.processInputs();

        temporaryMovement();

    }

    public void checkTps() {

        double lastCheckTime = System.nanoTime();

        while (true) {

            if (hasOneSecondElapsed(lastCheckTime)) {

                TPS = TICKS;
                TICKS = 0;
                lastCheckTime = System.nanoTime();

            }

        }

    }

    private static void temporaryMovement() {

        if (KeyUtils.hasJustPressed(KeyEvent.VK_D) || KeyUtils.isHolding(KeyEvent.VK_D)) {

            GamePanel.x += 5;

        }

        if (KeyUtils.hasJustPressed(KeyEvent.VK_A) || KeyUtils.isHolding(KeyEvent.VK_A)) {

            GamePanel.x -= 5;

        }

        if (KeyUtils.hasJustPressed(KeyEvent.VK_W) || KeyUtils.isHolding(KeyEvent.VK_W)) {

            GamePanel.y -= 5;

        }

        if (KeyUtils.hasJustPressed(KeyEvent.VK_S) || KeyUtils.isHolding(KeyEvent.VK_S)) {

            GamePanel.y += 5;

        }

        if (KeyUtils.hasJustPressed(KeyEvent.VK_SPACE)) {

            GamePanel.y -= 15;

        }

    }

    public static int getTps() {

        return TPS;

    }

    private static double calculateElapsedTickTime(double lastTickTime, long currentTickTime) {

        return (currentTickTime - lastTickTime) / SimulationThread.TICK_TIME;

    }

    private static boolean hasOneSecondElapsed(double lastCheckTime) {

        return System.nanoTime() - lastCheckTime >= TimeUtils.toNanoSeconds(1);

    }

}
