package com.example.tacotruck.pokemonsimon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by taco truck on 11/9/2015.
 */
public class levelsMap {
    private static levelsMap ourInstance = null;

    //level one
    private final int l1_pk1_sound = R.raw.caterpie;
    private final int l1_pk2_sound = R.raw.weedle;
    private final int l1_pk3_sound = R.raw.kakuna;
    private final int l1_pk4_sound = R.raw.metapod;
    private final int l1_pk1_pic = R.mipmap.caterpie;
    private final int l1_pk2_pic = R.mipmap.weedle;
    private final int l1_pk3_pic = R.mipmap.kakuna;
    private final int l1_pk4_pic = R.mipmap.metapod;
    private final int l1_background = R.mipmap.grass;

    //level two
    private final int l2_pk1_sound = R.raw.geodude;
    private final int l2_pk2_sound = R.raw.onyx;
    private final int l2_pk3_sound = R.raw.diglett;
    private final int l2_pk4_sound = R.raw.sandshrew;
    private final int l2_pk1_pic = R.mipmap.geodude;
    private final int l2_pk2_pic = R.mipmap.onyx;
    private final int l2_pk3_pic = R.mipmap.diglett;
    private final int l2_pk4_pic = R.mipmap.sandshrew;
    private final int l2_background = R.mipmap.rock;

    //level three
    private final int l3_pk1_sound = R.raw.starmie;
    private final int l3_pk2_sound = R.raw.staryu;
    private final int l3_pk3_sound = R.raw.shellder;
    private final int l3_pk4_sound = R.raw.goldeen;
    private final int l3_pk1_pic = R.mipmap.starmie;
    private final int l3_pk2_pic = R.mipmap.staryu;
    private final int l3_pk3_pic = R.mipmap.shellder;
    private final int l3_pk4_pic = R.mipmap.goldeen;
    private final int l3_background = R.mipmap.water;

    //level four
    private final int l4_pk1_sound = R.raw.voltorb;
    private final int l4_pk2_sound = R.raw.pikachu;
    private final int l4_pk3_sound = R.raw.raichu;
    private final int l4_pk4_sound = R.raw.magnemite;
    private final int l4_pk1_pic = R.mipmap.voltorb;
    private final int l4_pk2_pic = R.mipmap.pickachu;
    private final int l4_pk3_pic = R.mipmap.raichu;
    private final int l4_pk4_pic = R.mipmap.magnemite;
    private final int l4_background = R.mipmap.electric;

    //level five
    private final int l5_pk1_sound = R.raw.victreebell;
    private final int l5_pk2_sound = R.raw.tangela;
    private final int l5_pk3_sound = R.raw.vileplume;
    private final int l5_pk4_sound = R.raw.oddish;
    private final int l5_pk1_pic = R.mipmap.victreebell;
    private final int l5_pk2_pic = R.mipmap.tangela;
    private final int l5_pk3_pic = R.mipmap.vileplume;
    private final int l5_pk4_pic = R.mipmap.oddish;
    private final int l5_background = R.mipmap.celadon;

    //level six
    private final int l6_pk1_sound = R.raw.mrmime;
    private final int l6_pk2_sound = R.raw.venomoth;
    private final int l6_pk3_sound = R.raw.alakazam;
    private final int l6_pk4_sound = R.raw.kadabra;
    private final int l6_pk1_pic = R.mipmap.mrmime;
    private final int l6_pk2_pic = R.mipmap.venomoth;
    private final int l6_pk3_pic = R.mipmap.alakazam;
    private final int l6_pk4_pic = R.mipmap.kadabra;
    private final int l6_background = R.mipmap.saffron;

    //level seven
    private final int l7_pk1_sound = R.raw.koffing;
    private final int l7_pk2_sound = R.raw.muk;
    private final int l7_pk3_sound = R.raw.koffing;
    private final int l7_pk4_sound = R.raw.weezing;
    private final int l7_pk1_pic = R.mipmap.koffing;
    private final int l7_pk2_pic = R.mipmap.muk;
    private final int l7_pk3_pic = R.mipmap.koffing;
    private final int l7_pk4_pic = R.mipmap.weezing;
    private final int l7_background = R.mipmap.fuchsia;

    //level eight
    private final int l8_pk1_sound = R.raw.growlith;
    private final int l8_pk2_sound = R.raw.ponytha;
    private final int l8_pk3_sound = R.raw.rapidash;
    private final int l8_pk4_sound = R.raw.arcanine;
    private final int l8_pk1_pic = R.mipmap.growlithe;
    private final int l8_pk2_pic = R.mipmap.ponyta;
    private final int l8_pk3_pic = R.mipmap.rapidash;
    private final int l8_pk4_pic = R.mipmap.arcanine;
    private final int l8_background = R.mipmap.cinnabar;

    //maps
    private final HashMap<Integer, ArrayList<Integer>> levelToPokemon= new HashMap<>();
    private final HashMap<Integer, ArrayList<Integer>> levelToSound= new HashMap<>();
    private final HashMap<Integer, ArrayList<Integer>> levelToBackground= new HashMap<>();



    public static levelsMap getInstance() {
        if(ourInstance == null){
            ourInstance = new levelsMap();
        }
        return ourInstance;
    }

    private levelsMap() {
        //init maps here
        levelToPokemon.put(1, new ArrayList<Integer>(Arrays.asList(l1_pk1_pic, l1_pk2_pic, l1_pk3_pic, l1_pk4_pic)));
        levelToPokemon.put(2, new ArrayList<Integer>(Arrays.asList(l2_pk1_pic, l2_pk2_pic, l2_pk3_pic, l2_pk4_pic)));
        levelToPokemon.put(3, new ArrayList<Integer>(Arrays.asList(l3_pk1_pic, l3_pk2_pic, l3_pk3_pic, l3_pk4_pic)));
        levelToPokemon.put(4, new ArrayList<Integer>(Arrays.asList(l4_pk1_pic, l4_pk2_pic, l4_pk3_pic, l4_pk4_pic)));
        levelToPokemon.put(5, new ArrayList<Integer>(Arrays.asList(l5_pk1_pic, l5_pk2_pic, l5_pk3_pic, l5_pk4_pic)));
        levelToPokemon.put(6, new ArrayList<Integer>(Arrays.asList(l6_pk1_pic, l6_pk2_pic, l6_pk3_pic, l6_pk4_pic)));
        levelToPokemon.put(7, new ArrayList<Integer>(Arrays.asList(l7_pk1_pic, l7_pk2_pic, l7_pk3_pic, l7_pk4_pic)));
        levelToPokemon.put(8, new ArrayList<Integer>(Arrays.asList(l8_pk1_pic, l8_pk2_pic, l8_pk3_pic, l8_pk4_pic)));


        levelToSound.put(1, new ArrayList<Integer>(Arrays.asList(l1_pk1_sound, l1_pk2_sound, l1_pk3_sound, l1_pk4_sound)));
        levelToSound.put(2, new ArrayList<Integer>(Arrays.asList(l2_pk1_sound, l2_pk2_sound, l2_pk3_sound, l2_pk4_sound)));
        levelToSound.put(3, new ArrayList<Integer>(Arrays.asList(l3_pk1_sound, l3_pk2_sound, l3_pk3_sound, l3_pk4_sound)));
        levelToSound.put(4, new ArrayList<Integer>(Arrays.asList(l4_pk1_sound, l4_pk2_sound, l4_pk3_sound, l4_pk4_sound)));
        levelToSound.put(5, new ArrayList<Integer>(Arrays.asList(l5_pk1_sound, l5_pk2_sound, l5_pk3_sound, l5_pk4_sound)));
        levelToSound.put(6, new ArrayList<Integer>(Arrays.asList(l6_pk1_sound, l6_pk2_sound, l6_pk3_sound, l6_pk4_sound)));
        levelToSound.put(7, new ArrayList<Integer>(Arrays.asList(l7_pk1_sound, l7_pk2_sound, l7_pk3_sound, l7_pk4_sound)));
        levelToSound.put(8, new ArrayList<Integer>(Arrays.asList(l8_pk1_sound, l8_pk2_sound, l8_pk3_sound, l8_pk4_sound)));

        levelToBackground.put(1, new ArrayList<Integer>(Arrays.asList(l1_background)));
        levelToBackground.put(2, new ArrayList<Integer>(Arrays.asList(l2_background)));
        levelToBackground.put(3, new ArrayList<Integer>(Arrays.asList(l3_background)));
        levelToBackground.put(4, new ArrayList<Integer>(Arrays.asList(l4_background)));
        levelToBackground.put(5, new ArrayList<Integer>(Arrays.asList(l5_background)));
        levelToBackground.put(6, new ArrayList<Integer>(Arrays.asList(l6_background)));
        levelToBackground.put(7, new ArrayList<Integer>(Arrays.asList(l7_background)));
        levelToBackground.put(8, new ArrayList<Integer>(Arrays.asList(l8_background)));
    }

    public ArrayList<Integer> getPokemon(int level) {
        return levelToPokemon.get(level);
    }

    public ArrayList<Integer> getSound(int level) {
        return levelToSound.get(level);
    }

    public ArrayList<Integer> getBackground(int level) {
        return levelToBackground.get(level);
    }

}
