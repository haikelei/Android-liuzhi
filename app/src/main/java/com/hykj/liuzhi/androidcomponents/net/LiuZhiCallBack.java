package com.hykj.liuzhi.androidcomponents.net;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.hykj.liuzhi.androidcomponents.bean.LiuZhiBean;
import com.zhouyou.http.callback.CallBack;
import com.zhouyou.http.exception.ApiException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author: lujialei
 * @date: 2018/11/11
 * @describe:
 */


public abstract class LiuZhiCallBack<T> extends CallBack<String> {
    Gson gson = new Gson();

    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onSuccess(String s) {
        return;
//        LiuZhiBean bean = gson.fromJson(s,LiuZhiBean.class);
//        if (bean==null){
//            return;
//        }
//        if (bean.code!=0){
//            onError(new ApiException());
//        }
    }

    @Override
    public void onError(ApiException e) {

    }





}
