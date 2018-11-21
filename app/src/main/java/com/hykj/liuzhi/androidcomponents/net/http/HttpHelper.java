package com.hykj.liuzhi.androidcomponents.net.http;

import com.hykj.liuzhi.androidcomponents.bean.LoginEntity;
import com.hykj.liuzhi.androidcomponents.utils.FastJSONHelper;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;

public class HttpHelper {
    public static void login(String phone, String code , final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit( 15l,15l).create(HttpService.class);
        httpService.login(phone,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper").i( succeed);
                        LoginEntity entity = FastJSONHelper.getPerson(succeed, LoginEntity.class);
                        if (entity.getCode() == 0){
                            if (entity.getError() == 0){
                                callBack.onSucceed(succeed);
                            }else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        }else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i( e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }

    public static void register(String phone, String code ,String password ,final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit( 15l,15l).create(HttpService.class);
        httpService.register(phone,code,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper").i(succeed);
                        LoginEntity entity = FastJSONHelper.getPerson(succeed, LoginEntity.class);
                        if (entity.getCode() == 0){
                            if (entity.getError() == 0){
                                callBack.onSucceed(succeed);
                            }else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        }else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i( e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }

    public static void getUserself(final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit( 15l,15l).create(HttpService.class);
        httpService.getUserself()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper").i(succeed);
//                        LoginEntity entity = FastJSONHelper.getPerson(succeed, LoginEntity.class);
//                        if (entity.getCode() == 0){
//                            if (entity.getError() == 0){
//                                callBack.onSucceed(succeed);
//                            }else {
//                                callBack.onError(String.valueOf(entity.getError()));
//                            }
//                        }else {
//                            callBack.onFailure(String.valueOf(entity.getError()));
//                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i( e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }

    public interface HttpUtilsCallBack<T> {
        public void onFailure(String failure);
        public void onSucceed(T succeed);
        public void onError(String error);
    }

    private static String httpFailureMsg(){
         if (NetUtils.isConnected()) {
             return "很抱歉，系统繁忙，请稍后重试。";
        } else {
             return"检查网络连接情况，请稍后重试。";
        }
    }
}
