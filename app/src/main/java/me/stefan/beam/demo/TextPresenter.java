package me.stefan.beam.demo;

import me.stefan.beam.expansion.BeamBasePresenter;

/**
 * TextPresenter
 * <p>
 * Created by Stefan on 2017/10/11.
 */

public class TextPresenter extends BeamBasePresenter<TextFragment> {

    public void goThird() {
        startNextActivity(ThirdActivity.class);
    }

}
