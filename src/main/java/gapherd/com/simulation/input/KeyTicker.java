package gapherd.com.simulation.input;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class KeyTicker {


    //TODO - Make variables protected with getters
    public static final Set<Integer> HOLDING_KEYS = new HashSet<>();
    public static final Set<Integer> JUST_PRESSED_KEYS = new HashSet<>();
    public static final Set<Integer> PRESSED_KEYS = new HashSet<>();
    public static final Set<Integer> PRESSING_KEYS = new HashSet<>();

    private static final Map<Integer, Integer> keyTickMap = new HashMap<>();
    private static final int TICKS_FOR_HOLDING = 8;

    public static void processInputs() {

        clearTickedKeys();

        PRESSING_KEYS.forEach(tickPressingKeys());

        tickReleasedKeys().forEach(keyTickMap::remove);

    }

    private static void clearTickedKeys() {

        PRESSED_KEYS.clear();
        JUST_PRESSED_KEYS.clear();

    }

    private static Consumer<Integer> tickPressingKeys() {

        return key -> {

            if (keyTickMap.containsKey(key)) {

                int keyTick = keyTickMap.get(key);
                if (keyTick > TICKS_FOR_HOLDING) {

                    HOLDING_KEYS.add(key);

                }

                keyTickMap.put(key, keyTick + 1);

            } else {

                PRESSED_KEYS.add(key);

                keyTickMap.put(key, 1);

            }

        };

    }

    private static Set<Integer> tickReleasedKeys() {

        Set<Integer> releasedKeysSet = new HashSet<>();

        keyTickMap.forEach(tickHoldingKeysAndJustPressedKeys(releasedKeysSet));

        return releasedKeysSet;

    }

    private static BiConsumer<Integer, Integer> tickHoldingKeysAndJustPressedKeys(Set<Integer> releasedKeysSet) {

        return (key, tick) -> {

            if (!PRESSING_KEYS.contains(key)) {

                if (tick <= TICKS_FOR_HOLDING) {

                    JUST_PRESSED_KEYS.add(key);

                }

                HOLDING_KEYS.remove(key);
                releasedKeysSet.add(key);

            }

        };

    }


}
