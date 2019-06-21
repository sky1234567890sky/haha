package com.example.day09lianxicejiu.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day09lianxicejiu.Main2Activity;
import com.example.day09lianxicejiu.MainActivity;
import com.example.day09lianxicejiu.R;
import com.example.day09lianxicejiu.adapter.AdapterRx;
import com.example.day09lianxicejiu.api.FzBean;
import com.example.day09lianxicejiu.api.SjBean;
import com.example.day09lianxicejiu.dao.Api;
import com.example.day09lianxicejiu.dao.daoUtil;
import com.example.day09lianxicejiu.molder.Imolder;
import com.example.day09lianxicejiu.mview.Mview;
import com.example.day09lianxicejiu.prenter.Imprenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class SyFragment extends Fragment implements Mview {


    private View view;
    /**
     * Hello blank fragment
     */
    private RecyclerView mRv;
    private ArrayList<FzBean.DataBean.DatasBean> mList;
    private AdapterRx mAdapterRx;
    private Imprenter mImprenter;

    public SyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_sy, container, false);
        initView(inflate);
        mImprenter = new Imprenter(new Imolder(), this);
        mImprenter.getData();
        return inflate;
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRv.setLayoutManager(manager);

        mList = new ArrayList<>();
        mAdapterRx = new AdapterRx(mList, getContext());
        mRv.setAdapter(mAdapterRx);


        mAdapterRx.setOnLongClickListener(new AdapterRx.OnLongClickListener() {
            @Override
            public void OnLongClickListener(int position) {
                Intent intent = new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
            }

        });


        mAdapterRx.setOnClickListener(new AdapterRx.OnClickListener() {
            @Override
            public void OnClickListener(int position) {
                SjBean sjBean = new SjBean();
                sjBean.setTitle(mList.get(position).getTitle());
                sjBean.setEnvelopePic(mList.get(position).getEnvelopePic());
                daoUtil.getDaoUtil().insertItem(sjBean);
                Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();

            }
        });
    }




    @Override
    public void Scuess(FzBean fzBean) {
        List<FzBean.DataBean.DatasBean> datas = fzBean.getData().getDatas();
        mList.addAll(datas);
        mAdapterRx.notifyDataSetChanged();
    }

    @Override
    public void Error(String error) {
        Log.e("tag", "Error: "+error );
    }
}
