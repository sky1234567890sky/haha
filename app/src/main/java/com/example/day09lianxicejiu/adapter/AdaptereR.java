package com.example.day09lianxicejiu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day09lianxicejiu.R;
import com.example.day09lianxicejiu.api.SjBean;

import java.util.ArrayList;

/**
 * Created by 小乐乐 on 2019/6/10.
 */

public class AdaptereR extends RecyclerView.Adapter<AdaptereR.ViewHolder> {
    private ArrayList<SjBean> mList;
    private Context context;

    public AdaptereR(ArrayList<SjBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.onexml, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getEnvelopePic()).into(holder.mIvEnvelopePic);
        holder.mTvTitle.setText(mList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView mIvEnvelopePic;
        TextView mTvTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            this.mIvEnvelopePic = (ImageView) itemView.findViewById(R.id.iv_envelopePic);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
