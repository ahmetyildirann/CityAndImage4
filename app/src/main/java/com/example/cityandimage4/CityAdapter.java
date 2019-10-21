package com.example.cityandimage4;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ExampleViewHolder> {
    private ArrayList<CityModel> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {       //
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {            //
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {            //
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public CityAdapter(ArrayList<CityModel> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        CityModel currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getCityImage());
        holder.mTextView1.setText(currentItem.getCityName());
        holder.mTextView2.setText(currentItem.getCityUrl());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}
