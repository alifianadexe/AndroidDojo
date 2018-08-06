package com.alifianadexe.androidtrainingdojo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adexe on 6/5/18.
 */

public class RecycleViewItem extends RecyclerView.Adapter<RecycleViewItem.ViewHolder> {

    private ArrayList<String> datalist;
    private Context context;
    private int lastPosition = -1;

    // constructor
    public RecycleViewItem(Context context, ArrayList<String> datalist){
        this.datalist = datalist;
        this.context = context;
    }

    // membuat class view holder versi kita , agar lebih mudah dalam penginisialan nama attribut
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView lbl_header;
        public TextView lbl_subtitle;
        public Button btn_ok;
        public ImageView img_item;

        public ViewHolder(View itemView) {
            super(itemView);
            // inisiai attribut
            lbl_header = (TextView) itemView.findViewById(R.id.lbl_header);
            lbl_subtitle = (TextView) itemView.findViewById(R.id.lbl_subtitle);
            btn_ok = (Button) itemView.findViewById(R.id.btn_ok);
            img_item = (ImageView) itemView.findViewById(R.id.img_item);
        }
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);

        // kalian bisa mengeset ukuran , margin , padding , attribut dan lain - lain disini

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // disini kita bind item dari datalist ke ViewHolder
        // istilah nya mengambil data dan menampilkan data.

        holder.lbl_header.setText(datalist.get(position));
        holder.lbl_subtitle.setText("Ini adalah item ke - " + position);
        setAnimation(holder.itemView, position);
        //kita juga bisa membuat listener ataupun function langsung dari sini
        holder.btn_ok.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context,datalist.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        // disini kita harus mereturn jumlah dari item
        return datalist.size();
    }

    private void setAnimation(View viewToAnimate, int position){


//        if(position > lastPosition){
//            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
//            viewToAnimate.startAnimation(animation);
//            lastPosition = position;
//        }
    }

}
