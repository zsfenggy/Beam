package me.stefan.beam.bijection;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class Presenter<ViewType> {
    /**
     * activity only executes only once.
     *
     * @param view       ViewType
     * @param savedState Bundle
     */
    protected void onCreate(@NonNull ViewType view, Bundle savedState) {
    }

    /**
     * the call of presenter destroy.It represent activity finish.
     */
    protected void onDestroy() {
    }

    /**
     * the call of activity$OnCreate,but being executed after OnCreate.
     *
     * @param view ViewType
     */
    protected void onCreateView(@NonNull ViewType view) {
        this.view = view;
    }

    /**
     * the call of activity$OnDestroy
     */
    protected void onDestroyView() {
    }

    protected void onResume() {
    }

    protected void onPause() {
    }

    protected void onSave(Bundle state) {
    }

    protected void onResult(int requestCode, int resultCode, Intent data) {
    }

    String id;
    ViewType view;

    @NonNull
    public final ViewType getView() {
        return view;
    }

    void create(ViewType view, Bundle savedState) {
        this.view = view;
        onCreate(view, savedState);
    }
}
