package com.example.tacotruck.pokemonsimon;

import android.content.Context;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * Created by taco truck on 9/7/2015.
 */
public class Simon {
    ImageButton red;
    ImageButton yellow;
    ImageButton green;
    ImageButton blue;
    Button start;
    Boolean isPressed = Boolean.FALSE;
    Boolean hasPickedPokemon = Boolean.FALSE;
    Stack<Integer> pokemonStack = new Stack<>();
    ArrayList<Integer> pickedPokemon = new ArrayList<>();
    ArrayList<Integer> userPokemon = new ArrayList<>();
    Handler handler = new Handler();
    Integer count = -1;
    public static String WIN = "WIN";
    public static String LOSE = "LOSE";
    public Context mContext;

    public Simon() {

    }

    public void setStart(Button start) {
        this.start = start;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public void setBlue(ImageButton blue) {
        this.blue = blue;
    }

    public void setGreen(ImageButton green) {
        this.green = green;
    }

    public void setRed(ImageButton red) {
        this.red = red;
    }

    public void setYellow(ImageButton yellow) {
        this.yellow = yellow;
    }

    public void pickPokemon(int count) {
        //empty stack and arraylist
        this.count = count;
        hasPickedPokemon = Boolean.FALSE;
        pokemonStack = new Stack<>();
        pickedPokemon.clear();
        userPokemon.clear();
        System.out.println("pokemon stack is empty: " + pokemonStack.empty());

        //get random int between 0 to 3
        Random generator = new Random();
        for (int i = 0; i < count; i++) {
            pokemonStack.push(generator.nextInt(4));
        }

        //disable buttons
        red.setClickable(false);
        blue.setClickable(false);
        green.setClickable(false);
        yellow.setClickable(false);
        start.setClickable(false);

        handlerTest();

    }

    private void handlerTest() {
        if (isPressed) {
            clearSelection();
            isPressed = Boolean.FALSE;
            pokemonStack.pop();
        } else {
            int result = pokemonStack.peek();
            pickedPokemon.add(result);
            if (result == 0) {
                red.setPressed(true);
                red.performClick();

            } else if (result == 1) {
                yellow.setPressed(true);
                yellow.callOnClick();
            } else if (result == 2) {
                green.setPressed(true);
                green.callOnClick();
            } else {
                blue.setPressed(true);
                blue.callOnClick();
            }
            isPressed = Boolean.TRUE;
        }

        if (!pokemonStack.isEmpty()) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    handlerTest();
                }
            }, 500);
        } else {
            //enable buttons
            red.setClickable(true);
            blue.setClickable(true);
            green.setClickable(true);
            yellow.setClickable(true);

            hasPickedPokemon = Boolean.TRUE;
            userPokemon.clear();
        }
    }

    public void clearSelection() {
        red.setPressed(false);
        yellow.setPressed(false);
        green.setPressed(false);
        blue.setPressed(false);
    }

    public void updateSelection() {
        if (pickedPokemon.size() == count && hasPickedPokemon) {
            if (red.isPressed()) {
                userPokemon.add(0);
                System.out.println(userPokemon.toString());
            } else if (blue.isPressed()) {
                userPokemon.add(3);
                System.out.println(userPokemon.toString());
            } else if (green.isPressed()) {
                userPokemon.add(2);
                System.out.println(userPokemon.toString());
            } else {
                userPokemon.add(1);
                System.out.println(userPokemon.toString());
            }
        }
    }

    public String verifyPokemon() {
        if (pickedPokemon.size() == this.count && hasPickedPokemon) {
            if (userPokemon.size() == pickedPokemon.size()) {
                if (userPokemon.equals(pickedPokemon)) {
                    System.out.println("CORRECT");
                    Toast.makeText(mContext, "You WIN!", Toast.LENGTH_LONG).show();
                    System.out.println("pickedPkmn" + pickedPokemon.toString() + " == userPokemon" + userPokemon.toString());
                    hasPickedPokemon = Boolean.FALSE;
                    start.setClickable(true);
                    userPokemon.clear();
                    return (WIN);
                } else {
                    System.out.println("WRONG");
                    Toast.makeText(mContext, "You LOSE!", Toast.LENGTH_LONG).show();
                    System.out.println("pickedPokemon " + pickedPokemon.toString() + " != userPokemon" + userPokemon.toString());
                    hasPickedPokemon = Boolean.FALSE;
                    start.setClickable(true);
                    userPokemon.clear();
                    return (LOSE);
                }
            }
        }
        return ("");
    }


}
