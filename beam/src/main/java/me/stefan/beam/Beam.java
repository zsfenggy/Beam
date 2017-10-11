package me.stefan.beam;

import android.content.Context;

import me.stefan.beam.bijection.ActivityLifeCycleDelegate;
import me.stefan.beam.bijection.ActivityLifeCycleDelegateProvider;
import me.stefan.beam.bijection.BeamAppCompatActivity;
import me.stefan.beam.model.ModelManager;

/**
 * Created by Mr.Jude on 2015/7/26.
 */
public final class Beam {
    private static ActivityLifeCycleDelegateProvider mActivityLIfeCycleDelegateProvider;

    public static ActivityLifeCycleDelegate createActivityLifeCycleDelegate(BeamAppCompatActivity activity) {
        if (mActivityLIfeCycleDelegateProvider!=null)
            return mActivityLIfeCycleDelegateProvider.createActivityLifeCycleDelegate(activity);
        else return null;
    }

    public static void setActivityLifeCycleDelegateProvider(ActivityLifeCycleDelegateProvider activityLifeCycleDelegateClass){
        mActivityLIfeCycleDelegateProvider = activityLifeCycleDelegateClass;
    }

    public static void init(Context ctx){
        ModelManager.init(ctx);
    }

}
