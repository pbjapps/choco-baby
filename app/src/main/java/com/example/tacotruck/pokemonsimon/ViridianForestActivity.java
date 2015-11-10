package com.example.tacotruck.pokemonsimon;

public class ViridianForestActivity extends BaseLevelActivity {

    public ViridianForestActivity() {
        this.mapId = R.layout.activity_viridian_forest;
        this.mapMenuId = R.menu.menu_viridian_forest;
        this.pkmnCount = 8;
        this.pkmnOneImageId = R.id.imageView;
        this.pkmnTwoImageId = R.id.imageView2;
        this.pkmnThreeImageId = R.id.imageView3;
        this.pkmnFourImageId = R.id.imageView4;
        this.pkmnOneSoundId = R.raw.caterpie;
        this.pkmnTwoSoundId = R.raw.weedle;
        this.pkmnThreeSoundId = R.raw.kakuna;
        this.pkmnFourSoundId = R.raw.metapod;
    }
}
