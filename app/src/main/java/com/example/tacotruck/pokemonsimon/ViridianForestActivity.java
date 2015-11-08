package com.example.tacotruck.pokemonsimon;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class ViridianForestActivity extends Activity {

    MediaPlayer button_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viridian_forest);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        ImageButton caterpie = (ImageButton) findViewById(R.id.imageView);
        ImageButton weedle = (ImageButton) findViewById(R.id.imageView2);
        ImageButton kakuna = (ImageButton) findViewById(R.id.imageView3);
        ImageButton metapod = (ImageButton) findViewById(R.id.imageView4);
        Button startGame = (Button) findViewById(R.id.button3);

        final Simon simon = new Simon();
        simon.setBlue(caterpie);
        simon.setRed(weedle);
        simon.setGreen(kakuna);
        simon.setYellow(metapod);
        simon.setStart(startGame);
        simon.setmContext(getApplicationContext());

        caterpie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_sound = MediaPlayer.create(ViridianForestActivity.this,
                        R.raw.caterpie);
                button_sound.start();
                button_sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Boolean result = simon.verifyPokemon();
                if(!result){
                    viewMainActivity();
                }
            }
        });

        weedle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_sound = MediaPlayer.create(ViridianForestActivity.this,
                        R.raw.weedle);
                button_sound.start();
                button_sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Boolean result = simon.verifyPokemon();
                if(!result){
                    viewMainActivity();
                }
            }
        });

        kakuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_sound = MediaPlayer.create(ViridianForestActivity.this,
                        R.raw.kakuna);
                button_sound.start();
                button_sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Boolean result = simon.verifyPokemon();
                if(!result){
                    viewMainActivity();
                }
            }
        });

        metapod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_sound = MediaPlayer.create(ViridianForestActivity.this,
                        R.raw.metapod);
                button_sound.start();
                button_sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Boolean result = simon.verifyPokemon();
                if(!result){
                    viewMainActivity();
                }
            }
        });

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simon.pickPokemon(3);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_viridian_forest, menu);
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

    public void viewMainActivity(){
        Intent myIntent = new Intent(ViridianForestActivity.this, MainMenuActivity.class);
        ViridianForestActivity.this.startActivity(myIntent);
    }
}
