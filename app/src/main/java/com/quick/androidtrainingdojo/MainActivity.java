package com.quick.androidtrainingdojo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quick.androidtrainingdojo.baseactivity.AppBaseActivity;

public class MainActivity extends AppBaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
