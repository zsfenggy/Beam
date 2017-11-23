package me.stefan.beam.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import me.stefan.beam.bijection.RequiresPresenter;
import me.stefan.beam.expansion.BeamBaseActivity;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BeamBaseActivity<MainPresenter> implements View.OnClickListener,
        View.OnLongClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        textView.setOnClickListener(this);
        textView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text:
                String text = getPresenter().getText();
                textView.setText(text);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        getPresenter().goSecond();
        return false;
    }

}