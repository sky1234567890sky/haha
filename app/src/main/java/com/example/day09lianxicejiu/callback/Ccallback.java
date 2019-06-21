package com.example.day09lianxicejiu.callback;

import com.example.day09lianxicejiu.api.FzBean;

/**
 * Created by 小乐乐 on 2019/6/10.
 */

public interface Ccallback {
    void Scuess(FzBean fzBean);
    void Error(String error);
}
