package me.stefan.beam.expansion;

import android.view.MenuItem;

import me.stefan.beam.bijection.BeamAppCompatActivity;
import me.stefan.beam.bijection.Presenter;

/**
 * Created by Mr.Jude on 2015/8/17.
 */
public class BeamBaseActivity<T extends Presenter> extends BeamAppCompatActivity<T> {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}