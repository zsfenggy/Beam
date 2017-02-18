package me.stefan.beam.expansion.data;

import android.support.annotation.Nullable;

import me.stefan.beam.bijection.RequiresPresenter;
import me.stefan.beam.expansion.BeamBaseActivity;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
@RequiresPresenter(BeamDataActivityPresenter.class)
public class BeamDataActivity<T extends BeamDataActivityPresenter,M> extends BeamBaseActivity<T>{

    public void setData(@Nullable M data){}
    public void setError(Throwable e){
        throw new RuntimeException(e);
    }

}
