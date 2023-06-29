package gapherd.com.simulation.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyListenerImpl implements KeyListener {

    //TODO - Make variables protected
    public static Set<Integer> PRESSED_KEYS = new HashSet<>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        KeyTicker.PRESSING_KEYS.add(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

        KeyTicker.PRESSING_KEYS.remove(e.getKeyCode());

    }

}
