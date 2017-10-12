package me.setfan.beam;

import java.util.Random;

import me.stefan.beam.expansion.BeamBasePresenter;

/**
 * Created by Stefan on 2017/10/11.
 */

public class MainPresenter extends BeamBasePresenter<MainActivity> {

    private String[] array = {
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    public String getText() {
        Random random = new Random();
        int n = random.nextInt(26);
        int i = Math.abs(n) % array.length;
        return i < array.length - 1 ? array[i] : "";
    }


    public void goSecond() {
        startNextActivity(SecondActivity.class);
    }

}