package gapherd.com;

import gapherd.com.render.RenderThread;
import gapherd.com.simulation.SimulationThread;

public class Main {

    public static void main(String[] args) {

        new Thread(new RenderThread()).start();
        new Thread(new SimulationThread()).start();

    }

}