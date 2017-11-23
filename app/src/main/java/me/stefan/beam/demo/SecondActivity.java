package me.stefan.beam.demo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import me.stefan.beam.expansion.BeamBaseActivity;

/**
 * SecondActivity
 * <p>
 * Created by Stefan on 2017/10/11.
 */

public class SecondActivity extends BeamBaseActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        int position = 0;
        switch (checkedId) {
            case R.id.rb1:
                position = 0;
                break;
            case R.id.rb2:
                position = 1;
                break;
            case R.id.rb3:
                position = 2;
                break;
            case R.id.rb4:
                position = 3;
                break;
            case R.id.rb5:
                position = 4;
                break;
        }
        setFragment(position);
    }

    private void initView() {
        mContainer = findViewById(R.id.container);
        RadioGroup radioGroup = findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(this);
        setFragment(0);
    }

    private void setFragment(int position) {
        Fragment fragment = (Fragment) mFragmentStatePagerAdapter
                .instantiateItem(mContainer, position);
        mFragmentStatePagerAdapter.setPrimaryItem(mContainer, 0, fragment);
        mFragmentStatePagerAdapter.finishUpdate(mContainer);
    }

    private FragmentStatePagerAdapter mFragmentStatePagerAdapter = new FragmentStatePagerAdapter(
            getSupportFragmentManager()) {
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TextFragment.newInstance(1);
                case 1:
                    return TextFragment.newInstance(2);
                case 2:
                    return TextFragment.newInstance(3);
                case 3:
                    return TextFragment.newInstance(4);
                case 4:
                    return TextFragment.newInstance(5);
                default:
                    return TextFragment.newInstance(1);
            }
        }
    };

}
