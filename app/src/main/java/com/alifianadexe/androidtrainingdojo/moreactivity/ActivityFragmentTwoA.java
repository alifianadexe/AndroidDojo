package com.alifianadexe.androidtrainingdojo.moreactivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alifianadexe.androidtrainingdojo.R;
import com.alifianadexe.androidtrainingdojo.baseactivity.AppBaseActivity;

/**
 * Created by ditya on 5/24/18.
 */

public class ActivityFragmentTwoA extends AppBaseActivity {

    private Button btn_sifat;
    private CardView cardview,cardview1;
    private ImageView img_red;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentactivity_a);
        setupWindowsAnimation();

        cardview1   = (CardView) findViewById(R.id.cardview2);
        cardview   = (CardView) findViewById(R.id.cardview1);
        img_red = (ImageView) findViewById(R.id.imageView_a2);
        btn_sifat = (Button) findViewById(R.id.btn_sifat_manusia);
        btn_sifat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityFragmentTwoB.class);
                ActivityOptionsCompat  options = ActivityOptionsCompat.makeSceneTransitionAnimation(ActivityFragmentTwoA.this,null);
                startActivity(intent, options.toBundle());
            }
        });

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityFragmentTwoC.class);

                String transname = getString(R.string.red_name);

                ActivityOptionsCompat  options = ActivityOptionsCompat.makeSceneTransitionAnimation(ActivityFragmentTwoA.this,img_red, transname);
                startActivity(intent, options.toBundle());
            }
        });

        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityFragmentTwoC.class);

                String transname = getString(R.string.yellow_name);

                ActivityOptionsCompat  options = ActivityOptionsCompat.makeSceneTransitionAnimation(ActivityFragmentTwoA.this,img_red, transname);
                startActivity(intent, options.toBundle());
            }
        });


    }

    private void setupWindowsAnimation() {

        Transition fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);


        Transition slide = new Slide();
        slide.setDuration(1000);
        getWindow().setReturnTransition(slide);

    }


}
