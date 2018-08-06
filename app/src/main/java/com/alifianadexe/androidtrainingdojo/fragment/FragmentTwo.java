package com.alifianadexe.androidtrainingdojo.fragment;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alifianadexe.androidtrainingdojo.R;
import com.alifianadexe.androidtrainingdojo.moreactivity.ActivityFragmentTwoA;

/**
 * Created by ditya on 5/23/18.
 */

public class FragmentTwo extends Fragment{

    private Button btn_sifat;


    public FragmentTwo(){
        // blank
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        // inflate the layout fragment
        View view = inflater.inflate(R.layout.fragment_two, viewGroup, false);
        btn_sifat = (Button) view.findViewById(R.id.btn_sifat);
        btn_sifat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityFragmentTwoA.class);
                ActivityOptionsCompat optionsCompact = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity());
                startActivity(intent, optionsCompact.toBundle());
            }
        });
        return view;


    }
}
