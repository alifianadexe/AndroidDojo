package com.alifianadexe.androidtrainingdojo.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alifianadexe.androidtrainingdojo.R;

/**
 * Created by ditya on 5/23/18.
 */

public class FragmentThree extends Fragment {
    public FragmentThree(){
        // blank
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        // inflate the layout fragment
        return inflater.inflate(R.layout.fragment_three, viewGroup, false);
    }
}
