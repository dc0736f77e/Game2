package com.victorbeil.alchemy;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    protected String[] elements;

    protected ElementContent elementContent = new ElementContent();

    protected MainActivity activity;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public Button mButton;
        protected MainActivity activity;
        public MyViewHolder(Button v,MainActivity a) {
            super(v);
            mButton = v;
            activity = a;
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getClass()== AppCompatButton.class) {
                        Button G =(Button) v;
                        activity.addElement(G.getText());
                    }

                }
            });
        }
    }

    public MyAdapter(MainActivity a) {
        this.activity = a;
        elements = elementContent.getBaseElements();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHolder holder) {
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        Button v = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v,activity);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mButton.setText(elements[position]);
    }

    @Override
    public int getItemCount() {
        return elements.length;
    }
}