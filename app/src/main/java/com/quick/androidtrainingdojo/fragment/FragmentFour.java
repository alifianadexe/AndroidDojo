package com.quick.androidtrainingdojo.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quick.androidtrainingdojo.R;

/**
 * Created by ditya on 5/23/18.
 */

public class FragmentFour extends Fragment {
    public FragmentFour(){
        // blank
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        // inflate the layout fragment
        return inflater.inflate(R.layout.fragment_four, viewGroup, false);
    }
}
