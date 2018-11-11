package com.hykj.liuzhi.androidcomponents.net;

import com.google.gson.Gson;
import com.zhouyou.http.callback.CallBack;

import java.lang.reflect.ParameterizedType;

/**
 * @author: lujialei
 * @date: 2018/11/11
 * @describe:
 */


public abstract class LiuZhiCallBack<T> extends CallBack<String> {
    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onSuccess(String s) {
        Gson gson = new Gson();
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T t = gson.fromJson(s,tClass);
        onSuc(t);
    }

    protected abstract void onSuc(T t);
}
