package com.quick.androidtrainingdojo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by adexe on 6/5/18.
 */


public class RecycleViewActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<String> datalist;

    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.recycler_view_layout);

        recyclerView = (RecyclerView) findViewById(R.id.rv_item);
        datalist = new ArrayList<>();
        initDatalist();

        // Layout Manager juga bisa disebut sebagai container/wadah yang mengatur layar.
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // jangan lupa untuk mengeset adapter untuk recyclerview
        // agar data pada datalist bisa ditamplikan di RecyclerView
        adapter = new RecycleViewItem(this,datalist);
        recyclerView.setAdapter(adapter);

    }

    public void initDatalist(){
        // generate datalist

        datalist.add("Adexe");
        datalist.add("Mawar");
        datalist.add("Melati");
        datalist.add("Anggrek");
        datalist.add("Kimi no Todoke");
        datalist.add("Isko Romanov");
        datalist.add("Saiki Kusuo");
    }
}
