package com.example.tacotruck.pokemonsimon;

/**
 * Created by taco truck on 11/9/2015.
 */
public class levelsMap {
    private static levelsMap ourInstance = new levelsMap();
    private final int example;

    public static levelsMap getInstance() {
        return ourInstance;
    }

    private levelsMap() {
        this.example = R.raw.caterpie;
    }

    public int getExample() {
        return example;
    }
}
