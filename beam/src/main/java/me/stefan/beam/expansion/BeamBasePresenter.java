package me.stefan.beam.expansion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import me.stefan.beam.bijection.Presenter;

/**
 * Created by Mr.Jude on 2016/3/20.
 */
public class BeamBasePresenter<T> extends Presenter<T> {

    public Activity getActivity() {
        Activity activity = null;
        Object obj = getView();
        if (obj instanceof Activity) activity = (Activity) obj;
        else if (obj instanceof Fragment) activity = ((Fragment) obj).getActivity();
        else
            throw new RuntimeException("No View Found");
        return activity;
    }

    public void startNextActivity(Class<? extends Activity> clazz) {
        Object obj = getView();
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            activity.startActivity(new Intent(activity, clazz));
        } else if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            Context context = fragment.getContext();
            fragment.startActivity(new Intent(context, clazz));
        }
    }

    public void startNextActivity(Class<? extends Activity> clazz, Intent intent) {
        Object obj = getView();
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            intent.setClass(activity, clazz);
            activity.startActivity(intent);
        } else if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            Context context = fragment.getContext();
            intent.setClass(context, clazz);
            fragment.startActivity(intent);
        }
    }

    public void startNextActivityForResult(Class<?> clazz, int requestCode) {
        Object obj = getView();
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            activity.startActivityForResult(new Intent(activity, clazz), requestCode);
        } else if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            Context context = fragment.getContext();
            fragment.startActivityForResult(new Intent(context, clazz), requestCode);
        }
    }

    public void startNextActivityForResult(Class<?> clazz, Intent intent, int requestCode) {
        Object obj = getView();
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            intent.setClass(activity, clazz);
            activity.startActivityForResult(intent, requestCode);
        } else if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            Context context = fragment.getContext();
            intent.setClass(context, clazz);
            fragment.startActivityForResult(intent, requestCode);
        }
    }

}
