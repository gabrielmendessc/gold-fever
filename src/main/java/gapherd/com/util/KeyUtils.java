package gapherd.com.util;

import gapherd.com.simulation.input.KeyTicker;

public class KeyUtils {

    public static boolean hasPressed(int key) {

        return KeyTicker.PRESSED_KEYS.contains(key);

    }

    public static boolean hasJustPressed(int key) {

        return KeyTicker.JUST_PRESSED_KEYS.contains(key);

    }

    public static boolean isHolding(int key) {

        return KeyTicker.HOLDING_KEYS.contains(key);

    }

}
