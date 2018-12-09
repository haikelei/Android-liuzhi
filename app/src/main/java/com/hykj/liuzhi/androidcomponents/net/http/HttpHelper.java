package com.hykj.liuzhi.androidcomponents.net.http;

import com.hykj.liuzhi.androidcomponents.bean.LoginEntity;
import com.hykj.liuzhi.androidcomponents.utils.FastJSONHelper;
import com.orhanobut.logger.Logger;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HttpHelper {
    public static void login(String phone, String code, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit (15l, 15l).create (HttpService.class);
        HashMap<String, String> map = new HashMap<> ();
        map.put ("phone", phone);
        map.put ("code", code);
        httpService.login (map)
                .subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Observer<String> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t ("HttpHelper").i (succeed);
                        LoginEntity entity = FastJSONHelper.getPerson (succeed, LoginEntity.class);
                        if (entity.getCode () == 0) {
                            if (entity.getError () == 0) {
                                callBack.onSucceed (succeed);
                            } else {
                                callBack.onError (entity.getMsg ());
                            }

                        } else {
                            callBack.onFailure (String.valueOf (entity.getError ()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t ("HttpHelper").i (e.getMessage ());
                        callBack.onFailure (httpFailureMsg ());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public static void register(String phone, String code, String password, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<> ();
        map.put ("phone", phone);
        map.put ("code", code);
        map.put ("password", password);
        HttpService httpService = RetrofitFactory.getRetrofit (15l, 15l).create (HttpService.class);
        httpService.register (map)
                .subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Observer<String> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t ("HttpHelper").i (succeed);
                        LoginEntity entity = FastJSONHelper.getPerson (succeed, LoginEntity.class);
                        if (entity.getCode () == 0) {
                            if (entity.getError () == 0) {
                                callBack.onSucceed (succeed);
                            } else {
                                callBack.onError (String.valueOf (entity.getError ()));
                            }
                        } else {
                            callBack.onFailure (String.valueOf (entity.getError ()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t ("HttpHelper").i (e.getMessage ());
                        callBack.onFailure (httpFailureMsg ());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 用户关注的人
     *
     * @param page
     * @param number
     * @param callBack
     */
    public static void getusercollection(int page, int number, int user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<> ();
        map.put ("page", page + "");
        map.put ("number", number + "");
        map.put ("user_id", user_id + "");
        HttpService httpService = RetrofitFactory.getRetrofit (15l, 15l).create (HttpService.class);
        httpService.getusercollection (map)
                .subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Observer<String> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t ("HttpHelper").i (succeed);
                        LoginEntity entity = FastJSONHelper.getPerson (succeed, LoginEntity.class);
                        if (entity.getCode () == 0) {
                            if (entity.getError () == 0) {

                                callBack.onSucceed (succeed);
                            } else {
                                callBack.onError (String.valueOf (entity.getError ()));
                            }
                        } else {
                            callBack.onFailure (String.valueOf (entity.getError ()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t ("HttpHelper").i (e.getMessage ());
                        callBack.onFailure (httpFailureMsg ());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

//        HttpManager.post(ApiConstant.GETUSERCOLLECTION)
//                .params("page",page + "")
//                .params("number",number + "")
//                .execute(new SimpleCallBack<GetuserfanseBean>() {
//                    @Override
//                    public void onError(ApiException e) {
//                        Logger.t("MainActivity").i(e.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(GetuserfanseBean bannerBean) {
//                        Logger.t("MainActivity").i(bannerBean.toString());
//                    }
//                });
    }

   //获取用户信息
   public static void getUserself(int user_id ,final HttpUtilsCallBack<String> callBack) {
       HttpService httpService = RetrofitFactory.getRetrofit (15l, 15l).create (HttpService.class);
       HashMap<String, String> map = new HashMap<> ();
       map.put("user_id",user_id + "");
       httpService.getUserself (map)
               .subscribeOn (Schedulers.io ())
               .observeOn (AndroidSchedulers.mainThread ())
               .subscribe (new Observer<String> () {
                   @Override
                   public void onSubscribe(Disposable d) {
                   }

                   @Override
                   public void onNext(String succeed) {
                       Logger.t ("HttpHelper").i (succeed);
                       LoginEntity entity = FastJSONHelper.getPerson (succeed, LoginEntity.class);
                       if (entity.getCode () == 0) {
                           callBack.onSucceed (succeed);
                       } else {
                           callBack.onFailure (String.valueOf (entity.getError ()));
                       }
                   }

                   @Override
                   public void onError(Throwable e) {
                       Logger.t ("HttpHelper").i (e.getMessage ());
                       callBack.onFailure (httpFailureMsg ());
                   }

                   @Override
                   public void onComplete() {
                   }
               });
   }
    /**
     * 用户粉丝
     * @param page
     * @param number
     * @param callBack
     */
    public static void getUserFan(int user_id,int page, int number ,final HttpUtilsCallBack<String> callBack) {
        HashMap<String,String> map = new HashMap<>();
        map.put("page",page + "");
        map.put("number",number + "");
        map.put("user_id",user_id + "");
        HttpService httpService = RetrofitFactory.getRetrofit( 15l,15l).create(HttpService.class);
        httpService.getUserFan (map)
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
    /**
     * 用户点击关注
     * @param callBack
     */
    public static void getUserClickAttention(int click_id, int user_id ,final HttpUtilsCallBack<String> callBack) {
        HashMap<String,String> map = new HashMap<>();
        map.put("coll",click_id + "");
        map.put("user_id",user_id + "");
        HttpService httpService = RetrofitFactory.getRetrofit( 15l,15l).create(HttpService.class);
        httpService.getUserClickAttention (map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper").i( succeed.toString ());
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
    /**
     * 用户收藏记录
     * @param number
     * @param callBack
     */
    public static void getUserCollection( int user_id ,int page,int number,int type,final HttpUtilsCallBack<String> callBack) {
        HashMap<String,String> map = new HashMap<>();
        map.put("user_id",user_id + "");
        map.put("page",page + "");
        map.put("number",number + "");
        map.put("type",type + "");

        HttpService httpService = RetrofitFactory.getRetrofit( 15l,15l).create(HttpService.class);
        httpService.getUserCollection (map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper").i( succeed.toString ());
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
    /**
     * 用户添加图文信息
     * @param callBack
     */
    public static void getUseraddImatext( int user_id ,String imagetexttext,String imagetextlabelid,int filesnum,final HttpUtilsCallBack<String> callBack) {
        HashMap<String,String> map = new HashMap<>();

        map.put("imagetexttext",imagetexttext + "");
        map.put("imagetextlabelid",imagetextlabelid + "");
        map.put("user_id",user_id + "");
        map.put("filesnum",filesnum + "");

        HttpService httpService = RetrofitFactory.getRetrofit( 15l,15l).create(HttpService.class);
        httpService.getUseraddImagText (map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper").i( succeed.toString ());
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


    public interface HttpUtilsCallBack<T> {
        public void onFailure(String failure);

        public void onSucceed(T succeed);

        public void onError(String error);
    }

    private static String httpFailureMsg() {
        if (NetUtils.isConnected ()) {
            return "很抱歉，系统繁忙，请稍后重试。";
        } else {
            return "检查网络连接情况，请稍后重试。";
        }
    }
}
