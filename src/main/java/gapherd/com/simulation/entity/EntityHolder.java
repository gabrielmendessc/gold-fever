package gapherd.com.simulation.entity;

import gapherd.com.simulation.entity.animation.Animation;
import gapherd.com.simulation.entity.animation.AnimationState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EntityHolder {

    private final List<String> tagList = new ArrayList<>();
    private final Map<AnimationState, Animation> animationStateMap = new HashMap<>();

    private int x;
    private int y;
    private long id;
    private AnimationState animationState;

    public void tick() {

        //Implement simulation logic;

    }

    public void render() {

        //TODO - Write graphics logic to the entity (Transform tiles from scene in entities????)

    }



}
