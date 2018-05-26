package com.quick.androidtrainingdojo.fragment;

import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.quick.androidtrainingdojo.R;

/**
 * Created by ditya on 5/23/18.
 */

public class FragmentOne extends Fragment {

    private RelativeLayout relativeLayout;
    private Button btn_show;
    private Button btn_hide;
    private Button btn_resize;
    private ImageView image;

    public FragmentOne(){
        // blank
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        // inflate the layout fragment

        View view =  inflater.inflate(R.layout.fragment_one, viewGroup, false);

        relativeLayout = (RelativeLayout) view.findViewById(R.id.anim1);
        btn_show = (Button) view.findViewById(R.id.btn_show);
        btn_hide = (Button) view.findViewById(R.id.btn_hide);
        btn_resize = (Button) view.findViewById(R.id.btn_resize);
        image = (ImageView) view.findViewById(R.id.imageView1);

        btn_show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= 19) {
                    Fade fade = new Fade();
                    fade.setDuration(1000);
                    TransitionManager.beginDelayedTransition(relativeLayout, fade);
                    if(image.getVisibility() == View.INVISIBLE){
                        image.setVisibility(View.VISIBLE);
                    }
                }else{
                    Snackbar.make(relativeLayout,"Sorry, Your API Below 19", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        btn_hide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= 19) {
                    Fade fade = new Fade();
                    fade.setDuration(1000);
                    TransitionManager.beginDelayedTransition(relativeLayout, fade);
                    if(image.getVisibility() == View.VISIBLE){
                        image.setVisibility(View.INVISIBLE);
                    }
                }else{
                    Snackbar.make(relativeLayout,"Sorry, Your API Below 19", Snackbar.LENGTH_SHORT).show();
                }
            }
        });


        btn_resize.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= 19){

                    TransitionManager.beginDelayedTransition(relativeLayout);
                    ViewGroup.LayoutParams params = image.getLayoutParams();

                    int h = image.getHeight();
                    int w = image.getWidth();

                    params.width = h/2;
                    params.height = w/2;

                    image.setLayoutParams(params);
                }else{
                    Snackbar.make(relativeLayout,"Sorry, Your API Below 19", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


}
