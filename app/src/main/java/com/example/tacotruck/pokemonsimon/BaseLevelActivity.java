package com.example.tacotruck.pokemonsimon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.StateListDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class BaseLevelActivity extends Activity {

    private Simon simon;
    protected int mapId = R.layout.activity_viridian_forest;
    protected int mapMenuId = R.menu.menu_viridian_forest;
    protected int pkmnCount = 1;
    protected int pkmnOneImageId = R.id.imageView;
    protected int pkmnTwoImageId = R.id.imageView;
    protected int pkmnThreeImageId = R.id.imageView;
    protected int pkmnFourImageId = R.id.imageView;
    protected int pkmnOneSoundId = R.raw.caterpie;
    protected int pkmnTwoSoundId = R.raw.caterpie;
    protected int pkmnThreeSoundId = R.raw.caterpie;
    protected int pkmnFourSoundId = R.raw.caterpie;
    protected int pkmnOnePicId = R.drawable.caterpie;
    protected int pkmnTwoPicId = R.drawable.weedle;
    protected int backgroundOneId = R.drawable.grass;
    protected int backgroundTwoId = R.drawable.rock;
    protected HashMap<Integer, ArrayList<Integer>> levelToPokemon= new HashMap<>();
    protected int level = 1;
    protected ImageButton pkmnOne, pkmnTwo, pkmnThree, pkmnFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mapId);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        pkmnOne = (ImageButton) findViewById(pkmnOneImageId);
        pkmnTwo = (ImageButton) findViewById(pkmnTwoImageId);
        pkmnThree = (ImageButton) findViewById(pkmnThreeImageId);
        pkmnFour = (ImageButton) findViewById(pkmnFourImageId);

        int startButtonId = R.id.button3;
        Button startButton = (Button) findViewById(startButtonId);

        //initialize map - background, pkmn, sound
        levelsMap.getInstance().getExample();
        levelToPokemon.put(1, new ArrayList<Integer>(Arrays.asList(backgroundOneId, pkmnOnePicId, pkmnOneSoundId)));
        levelToPokemon.put(2, new ArrayList<Integer>(Arrays.asList(backgroundTwoId, pkmnTwoPicId, pkmnTwoSoundId)));

        initLevel();

        simon = new Simon();
        simon.setBlue(pkmnOne);
        simon.setRed(pkmnTwo);
        simon.setGreen(pkmnThree);
        simon.setYellow(pkmnFour);
        simon.setStart(startButton);
        simon.setmContext(getApplicationContext());

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simon.pickPokemon(pkmnCount);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(mapMenuId, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void viewMainActivity() {
        Intent myIntent = new Intent(BaseLevelActivity.this, MainMenuActivity.class);
        BaseLevelActivity.this.startActivity(myIntent);
    }

    private void handlePkmnClick(int pkmnSoundId) {
        MediaPlayer buttonMediaPlayer = MediaPlayer.create(BaseLevelActivity.this, pkmnSoundId);
        buttonMediaPlayer.start();
        buttonMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        String result = simon.verifyPokemon();
        if (result.equals(Simon.LOSE)) {
            level = 1;
            viewMainActivity();
        }
        else if (result.equals(Simon.WIN) && level < 2) {
            level++;
            initLevel();
        }
        else if (result.equals(Simon.WIN)  && level >= 2){
            viewMainActivity();
        }
    }

    private void initLevel(){
        this.pkmnCount = level + 2;
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[] {android.R.attr.state_pressed},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[] {android.R.attr.state_focused},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[] {android.R.attr.state_selected},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[] { },
                getResources().getDrawable(levelToPokemon.get(level).get(0)));

        pkmnOne.setImageDrawable(states);

        states = new StateListDrawable();
        states.addState(new int[] {android.R.attr.state_pressed},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[] {android.R.attr.state_focused},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[]{android.R.attr.state_selected},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[]{},
                getResources().getDrawable(levelToPokemon.get(level).get(0)));

        pkmnTwo.setImageDrawable(states);

        states = new StateListDrawable();
        states.addState(new int[] {android.R.attr.state_pressed},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[] {android.R.attr.state_focused},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[]{android.R.attr.state_selected},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[]{},
                getResources().getDrawable(levelToPokemon.get(level).get(0)));

        pkmnThree.setImageDrawable(states);

        states = new StateListDrawable();
        states.addState(new int[] {android.R.attr.state_pressed},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[] {android.R.attr.state_focused},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[] {android.R.attr.state_selected},
                getResources().getDrawable(levelToPokemon.get(level).get(1)));
        states.addState(new int[]{},
                getResources().getDrawable(levelToPokemon.get(level).get(0)));

        pkmnFour.setImageDrawable(states);

        pkmnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(levelToPokemon.get(level).get(2));
            }
        });

        pkmnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(levelToPokemon.get(level).get(2));
            }
        });

        pkmnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(levelToPokemon.get(level).get(2));
            }
        });

        pkmnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(levelToPokemon.get(level).get(2));
            }
        });
    }
}
