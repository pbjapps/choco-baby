package com.example.tacotruck.pokemonsimon;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class BaseLevelActivity extends Activity {

    private Simon simon;
    protected int mapId = R.layout.activity_viridian_forest;
    protected int mapMenuId = R.menu.menu_viridian_forest;
    protected int pkmnCount = 2;
    protected int pkmnOneImageId = R.id.imageView;
    protected int pkmnTwoImageId = R.id.imageView;
    protected int pkmnThreeImageId = R.id.imageView;
    protected int pkmnFourImageId = R.id.imageView;
    protected int pkmnOneSoundId = R.raw.caterpie;
    protected int pkmnTwoSoundId = R.raw.caterpie;
    protected int pkmnThreeSoundId = R.raw.caterpie;
    protected int pkmnFourSoundId = R.raw.caterpie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mapId);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        ImageButton pkmnOne = (ImageButton) findViewById(pkmnOneImageId);
        ImageButton pkmnTwo = (ImageButton) findViewById(pkmnTwoImageId);
        ImageButton pkmnThree = (ImageButton) findViewById(pkmnThreeImageId);
        ImageButton pkmnFour = (ImageButton) findViewById(pkmnFourImageId);
        int startButtonId = R.id.button3;
        Button startButton = (Button) findViewById(startButtonId);

        simon = new Simon();
        simon.setBlue(pkmnOne);
        simon.setRed(pkmnTwo);
        simon.setGreen(pkmnThree);
        simon.setYellow(pkmnFour);
        simon.setStart(startButton);
        simon.setmContext(getApplicationContext());

        pkmnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(pkmnOneSoundId);
            }
        });

        pkmnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(pkmnTwoSoundId);
            }
        });

        pkmnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(pkmnThreeSoundId);
            }
        });

        pkmnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(pkmnFourSoundId);
            }
        });

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
        if (!simon.verifyPokemon()) {
            viewMainActivity();
        }
    }
}
