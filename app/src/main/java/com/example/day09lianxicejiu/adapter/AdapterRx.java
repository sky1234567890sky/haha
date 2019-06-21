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
import com.bumptech.glide.request.RequestOptions;
import com.example.day09lianxicejiu.R;
import com.example.day09lianxicejiu.api.FzBean;

import java.util.ArrayList;

/**
 * Created by 小乐乐 on 2019/6/10.
 */

public class AdapterRx extends RecyclerView.Adapter<AdapterRx.ViewHolder> {
    private ArrayList<FzBean.DataBean.DatasBean> mList;
    private Context context;

    public AdapterRx(ArrayList<FzBean.DataBean.DatasBean> list, Context context) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        RequestOptions requestOptions = RequestOptions.circleCropTransform().circleCrop();
        Glide.with(context).load(mList.get(position).getEnvelopePic()).apply(requestOptions).into(holder.mIvEnvelopePic);
            holder.mTvTitle.setText(mList.get(position).getTitle());

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (OnLongClickListener!=null){
                        OnLongClickListener.OnLongClickListener(position);
                    }
                    return false;
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (OnClickListener!=null){
                        OnClickListener.OnClickListener(position);
                    }
                }
            });
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
    public interface OnLongClickListener{
        void OnLongClickListener(int position);
    }
    private OnLongClickListener OnLongClickListener;

    public void setOnLongClickListener(AdapterRx.OnLongClickListener onLongClickListener) {
        OnLongClickListener = onLongClickListener;
    }

    public  interface OnClickListener{
        void OnClickListener(int position);
    }
    private OnClickListener OnClickListener;

    public void setOnClickListener(AdapterRx.OnClickListener onClickListener) {
        OnClickListener = onClickListener;
    }
}
