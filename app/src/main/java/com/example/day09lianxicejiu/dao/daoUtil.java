package com.example.day09lianxicejiu.dao;

import com.example.day09lianxicejiu.api.SjBean;
import com.example.lizhengjun.dao.DaoMaster;
import com.example.lizhengjun.dao.DaoSession;
import com.example.lizhengjun.dao.SjBeanDao;

import java.util.List;

/**
 * Created by 小乐乐 on 2019/6/10.
 */

public class daoUtil {
    private static daoUtil mDaoUtil;
    private final SjBeanDao mSjBeanDao;

    public static daoUtil getDaoUtil() {
        if (mDaoUtil==null){
            synchronized (daoUtil.class){
                if (mDaoUtil==null){
                    mDaoUtil=new daoUtil();
                }
            }
        }
        return mDaoUtil;
    }

    public daoUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Api.getmApi(), "lianxijiu.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mSjBeanDao = daoSession.getSjBeanDao();
    }
    public void insertItem(SjBean sjBean){
        mSjBeanDao.insertOrReplaceInTx(sjBean);
    }

    public List<SjBean> loallAll(){
       return mSjBeanDao.loadAll();
    }
}
