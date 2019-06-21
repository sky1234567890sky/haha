package com.example.day09lianxicejiu.prenter;

import android.util.Log;

import com.example.day09lianxicejiu.api.FzBean;
import com.example.day09lianxicejiu.callback.Ccallback;
import com.example.day09lianxicejiu.molder.Imolder;
import com.example.day09lianxicejiu.mview.Mview;

/**
 * Created by 小乐乐 on 2019/6/10.
 */

public class Imprenter implements Prenter, Ccallback {
    private Imolder mImolder;
    private Mview mMview;

    public Imprenter(Imolder imolder, Mview mview) {
        mImolder = imolder;
        mMview = mview;
    }

    @Override
    public void getData() {
        if (mImolder!=null){
            mImolder.getData(this);
        }
    }

    @Override
    public void Scuess(FzBean fzBean) {
        if (mMview!=null){
            mMview.Scuess(fzBean);
        }
        else {
            mMview.Error("error");
        }
    }

    @Override
    public void Error(String error) {
        Log.e("tag", "Error: "+error );
    }
}
