package com.example.day09lianxicejiu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day09lianxicejiu.R;
import com.example.day09lianxicejiu.adapter.AdaptereR;
import com.example.day09lianxicejiu.api.SjBean;
import com.example.day09lianxicejiu.dao.Api;
import com.example.day09lianxicejiu.dao.daoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WdFragment extends Fragment {


    private View view;
    /**
     * Hello blank fragment
     */
    private RecyclerView mRvv;
    private ArrayList<SjBean> mList;
    private AdaptereR mAdaptereR;

    public WdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_wd, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRvv = (RecyclerView) inflate.findViewById(R.id.rvv);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvv.setLayoutManager(manager);

        mList = new ArrayList<>();
        mAdaptereR = new AdaptereR(mList, getContext());
        mRvv.setAdapter(mAdaptereR);
        initchaxun();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            initchaxun();
        }
        else {
            if (mList!=null&&mList.size()>0){
                mList.clear();
            }
        }
    }

    private void initchaxun() {
        List<SjBean> sjBeans = daoUtil.getDaoUtil().loallAll();
        mList.addAll(sjBeans);
        mAdaptereR.notifyDataSetChanged();
    }
}
