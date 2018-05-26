package com.quick.androidtrainingdojo.moreactivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import android.transition.Transition;
import android.transition.Explode;
import android.transition.Slide;

import com.quick.androidtrainingdojo.R;
import com.quick.androidtrainingdojo.baseactivity.AppBaseActivity;

/**
 * Created by ditya on 5/24/18.
 */

public class ActivityFragmentTwoB extends AppBaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentactivity_b);
        setupWindowsAnimation();

    }

    private void setupWindowsAnimation() {

        Transition explode = new Explode();
        explode.setDuration(1000);
        getWindow().setEnterTransition(explode);

        Transition slide = new Slide();
        slide.setDuration(1000);
        getWindow().setReturnTransition(slide);

    }

}
