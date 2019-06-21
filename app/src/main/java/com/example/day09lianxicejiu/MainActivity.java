package com.example.day09lianxicejiu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.day09lianxicejiu.fragment.SyFragment;
import com.example.day09lianxicejiu.fragment.WdFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVip;
    private TabLayout mTab;
    private ArrayList<Fragment> mFragments;
    private SyFragment mSyFragment;
    private WdFragment mWdFragment;
    private ArrayList<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVip = (ViewPager) findViewById(R.id.vip);
        mTab = (TabLayout) findViewById(R.id.tab);

        mFragments = new ArrayList<>();
        mSyFragment = new SyFragment();
        mWdFragment = new WdFragment();
        mFragments.add(mSyFragment);
        mFragments.add(mWdFragment);

        mList = new ArrayList<>();
        mList.add("首页");
        mList.add("我的");

        Myolder myolder = new Myolder(getSupportFragmentManager(), mFragments,mList);
        mVip.setAdapter(myolder);
        mTab.setupWithViewPager(mVip);
        mTab.getTabAt(0).setIcon(R.drawable.xuanze1);
        mTab.getTabAt(1).setIcon(R.drawable.xuanze2);

    }
    class Myolder extends FragmentStatePagerAdapter{
        private ArrayList<Fragment> mFragments;
        private ArrayList<String> mList;

        public Myolder(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> list) {
            super(fm);
            mFragments = fragments;
            mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mList.get(position);
        }
    }
}
