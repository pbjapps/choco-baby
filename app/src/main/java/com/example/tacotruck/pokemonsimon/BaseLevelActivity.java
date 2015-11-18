package com.example.tacotruck.pokemonsimon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.StateListDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class BaseLevelActivity extends Activity {

    private Simon simon;
    protected int mapId = R.layout.activity_viridian_forest;
    protected int mapMenuId = R.menu.menu_viridian_forest;
    protected int pkmnCount = 1;
    protected int pkmnOneImageId = R.id.imageView;
    protected int pkmnTwoImageId = R.id.imageView2;
    protected int pkmnThreeImageId = R.id.imageView3;
    protected int pkmnFourImageId = R.id.imageView4;
    protected int textViewId = R.id.textView2;
    protected int level = 1;
    protected int toplevel = 8;
    protected ImageButton pkmnOne, pkmnTwo, pkmnThree, pkmnFour;
    protected TextView location;
    private ArrayList<ImageButton> buttons;
    private ArrayList<String> locations;
    levelsMap map = levelsMap.getInstance();
    protected GridView progressView;
    protected ProgressAdapter progressAdapter;
    private Handler handler = new Handler();
    private String latestResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mapId);

        progressView = (GridView) findViewById(R.id.progressView);
        progressAdapter = new ProgressAdapter(this);
        progressView.setAdapter(progressAdapter);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        location = (TextView) findViewById(textViewId);
        pkmnOne = (ImageButton) findViewById(pkmnOneImageId);
        pkmnTwo = (ImageButton) findViewById(pkmnTwoImageId);
        pkmnThree = (ImageButton) findViewById(pkmnThreeImageId);
        pkmnFour = (ImageButton) findViewById(pkmnFourImageId);
        buttons = new ArrayList<>(Arrays.asList(pkmnOne, pkmnTwo, pkmnThree, pkmnFour));
        locations = new ArrayList<>(Arrays.asList("Viridian Forest", "Pewter City", "Cerulean City",
                "Vermillion City", "Celadon City", "Saffron City", "Fuschia City",
                "Cinnabar Island"));

        int startButtonId = R.id.button3;
        Button startButton = (Button) findViewById(startButtonId);

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
        progressAdapter.updateProgress(-1);
        progressAdapter.notifyDataSetChanged();
        Intent myIntent = new Intent(BaseLevelActivity.this, MainMenuActivity.class);
        BaseLevelActivity.this.startActivity(myIntent);
        finish();
    }

    private void handlePkmnClick(int pkmnSoundId) {
        simon.updateSelection();
        MediaPlayer buttonMediaPlayer = MediaPlayer.create(BaseLevelActivity.this, pkmnSoundId);
        buttonMediaPlayer.start();
        buttonMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        progressAdapter.updateProgress(simon.userPokemon.size());
        progressAdapter.notifyDataSetChanged();
        latestResult = simon.verifyPokemon();
        handler.postDelayed(new Runnable() {
            public void run() {
                handleResult();
            }
        }, 500);
    }

    private void createStateListDrawable(Integer clickedDrawable, Integer defaultDrawable, ImageButton b) {
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed},
                getResources().getDrawable(clickedDrawable));
        states.addState(new int[]{android.R.attr.state_focused},
                getResources().getDrawable(clickedDrawable));
        states.addState(new int[]{android.R.attr.state_selected},
                getResources().getDrawable(clickedDrawable));
        states.addState(new int[]{},
                getResources().getDrawable(defaultDrawable));

        b.setImageDrawable(states);
    }

    private void initLevel() {
        pkmnCount = level + 2;
        latestResult = "";
        progressAdapter.updateProgress(-1);
        progressAdapter.notifyDataSetChanged();

        location.setText(locations.get(level - 1));

        for (int i = 0; i < map.getPokemon(level).size(); i++) {
            createStateListDrawable(map.getPokemon(level).get(i), map.getBackground(level).get(0), buttons.get(i));
        }

        pkmnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(map.getSound(level).get(0));
            }
        });

        pkmnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(map.getSound(level).get(1));
            }
        });

        pkmnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(map.getSound(level).get(2));
            }
        });

        pkmnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePkmnClick(map.getSound(level).get(3));
            }
        });
    }

    private void handleResult() {
        if (latestResult.equals(Simon.LOSE)) {
            level = 1;
            viewMainActivity();
        } else if (latestResult.equals(Simon.WIN) && level < toplevel) {
            level++;
            initLevel();
        } else if (latestResult.equals(Simon.WIN) && level >= toplevel) {
            viewMainActivity();
            Toast.makeText(this.getApplicationContext(), "You beat all 8 gym leaders! Now onto the Elite 4...", Toast.LENGTH_SHORT).show();
        }
    }
}
