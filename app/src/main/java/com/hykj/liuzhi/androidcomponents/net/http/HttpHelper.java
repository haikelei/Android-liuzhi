package com.hykj.liuzhi.androidcomponents.net.http;

import android.text.TextUtils;

import com.hykj.liuzhi.androidcomponents.bean.AddAddressBean;
import com.hykj.liuzhi.androidcomponents.bean.AddContextBean;
import com.hykj.liuzhi.androidcomponents.bean.AliiTabBean;
import com.hykj.liuzhi.androidcomponents.bean.CartBean;
import com.hykj.liuzhi.androidcomponents.bean.ConfirmOrderBean;
import com.hykj.liuzhi.androidcomponents.bean.DetailCommetListBean;
import com.hykj.liuzhi.androidcomponents.bean.LoginEntity;
import com.hykj.liuzhi.androidcomponents.bean.MineFileBean;
import com.hykj.liuzhi.androidcomponents.bean.SignInBean;
import com.hykj.liuzhi.androidcomponents.bean.TabBean;
import com.hykj.liuzhi.androidcomponents.bean.VideomessageBean;
import com.hykj.liuzhi.androidcomponents.ui.activity.min.ChangePasswordBean;
import com.hykj.liuzhi.androidcomponents.ui.activity.min.bean.AllAddBean;
import com.hykj.liuzhi.androidcomponents.ui.activity.min.bean.LoGinRecordBean;
import com.hykj.liuzhi.androidcomponents.ui.activity.video.bean.VideoPointBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.circle.bean.CircleFragmentBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.detail.bean.VideoDetailBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.shop.bean.CollectionBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.shop.bean.GetsowingBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.collect.bean.CollectBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.bean.FashionBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.bean.FirstpagedataBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.bean.VideoContextBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.shop.bean.GoodDetailDetailBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.shop.bean.ShopHomeBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.shop.bean.ShopSeacharBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.shop.bean.addshopcarBean;
import com.hykj.liuzhi.androidcomponents.utils.FastJSONHelper;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class HttpHelper {
    public static void login(String phone, String code, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("code", code);
        httpService.login(map)
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
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(entity.getMsg());
                            }

                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public static void register(String phone, String code, String password, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("code", code);
        map.put("password", password);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.register(map)
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
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
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
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page + "");
        map.put("number", number + "");
        map.put("user_id", user_id + "");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getusercollection(map)
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
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {

                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
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
    public static void getUserself(int user_id, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", user_id + "");
        httpService.getUserself(map)
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
                        if (entity.getCode() == 0) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 用户粉丝
     *
     * @param page
     * @param number
     * @param callBack
     */
    public static void getUserFan(int user_id, int page, int number, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page + "");
        map.put("number", number + "");
        map.put("user_id", user_id + "");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getUserFan(map)
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
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 用户点击关注
     *
     * @param callBack
     */
    public static void getUserClickAttention(int click_id, int user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("coll", click_id + "");
        map.put("user_id", user_id + "");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getUserClickAttention(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper").i(succeed.toString());
                        LoginEntity entity = FastJSONHelper.getPerson(succeed, LoginEntity.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 首页=推荐
     *
     * @param callBack
     */
    public static void getHomeFirstpagedata(String page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getFirstpagedata(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        FirstpagedataBean entity = FastJSONHelper.getPerson(succeed, FirstpagedataBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 首页=纹理
     *
     * @param callBack
     */
    public static void getFirstpagedatatexture(int page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Page", String.valueOf(page));
        map.put("Number", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getFirstpagedatatexture(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        FirstpagedataBean entity = FastJSONHelper.getPerson(succeed, FirstpagedataBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 首页=潮流
     *
     * @param callBack
     */
    public static void getFirstpagedatatrend(int page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Page", String.valueOf(page));
        map.put("Number", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getFirstpagedatatrend(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        FashionBean entity = FastJSONHelper.getPerson(succeed, FashionBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 首页=搜索历史
     *
     * @param callBack
     */
    public static void getuserselecthistory(int page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Page", String.valueOf(page));
        map.put("Number", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getUserselecthistory(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        FashionBean entity = FastJSONHelper.getPerson(succeed, FashionBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 首页=搜索
     *
     * @param callBack
     */
    public static void getuserselect(int page, String selectname, final String selecttype, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Page", String.valueOf(page));
        map.put("Number", "10");
        map.put("selectname", selectname);
        map.put("selecttype", selecttype);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getUserselect(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        VideoContextBean entity = FastJSONHelper.getPerson(succeed, VideoContextBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 首页=签到
     *
     * @param callBack
     */
    public static void getSignIn(String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getSignIn(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        SignInBean entity = FastJSONHelper.getPerson(succeed, SignInBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=签名修改
     *
     * @param callBack
     */
    public static void getChangeautograph(String autograph, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("autograph", autograph);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getChangeautograph(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        SignInBean entity = FastJSONHelper.getPerson(succeed, SignInBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=昵称修改
     *
     * @param callBack
     */
    public static void getChangenickname(String name, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", name);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getChangenickname(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        SignInBean entity = FastJSONHelper.getPerson(succeed, SignInBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getError()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=邮箱修改
     *
     * @param callBack
     */
    public static void getChangEmail(String email, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mail", email);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getChangEmail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        SignInBean entity = FastJSONHelper.getPerson(succeed, SignInBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=修改头像
     *
     * @param callBack
     */
    public static void geChangeUserPic(File file, final HttpUtilsCallBack<String> callBack) {
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("application/otcet-stream"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("userpic", file.getName(), requestFile);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getChangeUserPic(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        MineFileBean entity = FastJSONHelper.getPerson(succeed, MineFileBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=收藏
     *
     * @param callBack
     */
    public static void getUserCollection(String page, String type, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "10");
        map.put("type", type);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getUserCollection(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        CollectBean entity = FastJSONHelper.getPerson(succeed, CollectBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=修改密码
     *
     * @param callBack
     */
    public static void getChangePassword(String old, String psNew, String repeat, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("old", old);
        map.put("new", psNew);
        map.put("repeat", repeat);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getChangePassword(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        ChangePasswordBean entity = FastJSONHelper.getPerson(succeed, ChangePasswordBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=登录记录
     *
     * @param callBack
     */
    public static void getlogonrecord(String user_id, String page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "10");
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getlogonrecord(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        LoGinRecordBean entity = FastJSONHelper.getPerson(succeed, LoGinRecordBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=用户所有的收货地址
     *
     * @param callBack
     */
    public static void getUserAddress(String user_id, String page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "10");
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getUserAddress(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        AllAddBean entity = FastJSONHelper.getPerson(succeed, AllAddBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private static String httpFailureMsg() {
        if (NetUtils.isConnected()) {
            return "很抱歉，系统繁忙，请稍后重试。";
        } else {
            return "检查网络连接情况，请稍后重试。";
        }
    }

    /**
     * 我的=添加收货地址
     *
     * @param callBack
     */
    public static void Addshopaddress(String user_id, String name, String phone, String allname, String address, String regionid, String status, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", user_id);
        map.put("name", name);
        map.put("phone", phone);
        map.put("allname", allname);
        map.put("address", address);
        map.put("regionid", regionid);
        map.put("status", status);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getAddshopaddress(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        AddAddressBean entity = FastJSONHelper.getPerson(succeed, AddAddressBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=省
     *
     * @param callBack
     */
    public static void getprovinces(String page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getprovinces(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        AddContextBean entity = FastJSONHelper.getPerson(succeed, AddContextBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=市
     *
     * @param callBack
     */
    public static void getcitys(String page, String pid, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "10");
        map.put("pid", pid);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getcitys(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        AddContextBean entity = FastJSONHelper.getPerson(succeed, AddContextBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=区
     *
     * @param callBack
     */
    public static void getareas(String page, String pid, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "10");
        map.put("pid", pid);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getareas(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        AddContextBean entity = FastJSONHelper.getPerson(succeed, AddContextBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 我的=获取所有标签
     *
     * @param callBack
     */
    public static void getlabels(String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getlabels(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed.toString());
                        AliiTabBean entity = FastJSONHelper.getPerson(succeed, AliiTabBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的=修改标签
     *
     * @param callBack
     */
    public static void changelabel(String lables, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("labels", lables);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.changelabel(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        TabBean entity = FastJSONHelper.getPerson(succeed, TabBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 商=获取轮播图片
     *
     * @param callBack
     */
    public static void Getsowing(String page, String number, String type, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", number);
        map.put("type", type);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.Getsowing(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        GetsowingBean entity = FastJSONHelper.getPerson(succeed, GetsowingBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 商=商品展示
     *
     * @param callBack
     */
    public static void Goodsfirstpage(String page, String number, String ordertype, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", number);
        map.put("ordertype", ordertype);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.Goodsfirstpage(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        ShopHomeBean entity = FastJSONHelper.getPerson(succeed, ShopHomeBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 商=查看商品
     *
     * @param callBack
     */
    public static void showgoods(String goodsid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("goodsid", goodsid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.showgoods(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        GoodDetailDetailBean entity = FastJSONHelper.getPerson(succeed, GoodDetailDetailBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 商=商品收藏
     *
     * @param callBack
     */
    public static void goodscollection(String goodsid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("goodsid", goodsid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.goodscollection(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        CollectionBean entity = FastJSONHelper.getPerson(succeed, CollectionBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 商=取消收藏
     *
     * @param callBack
     */
    public static void goodsnotcollection(String goodsid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("goodsid", goodsid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.goodsnotcollection(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        CollectionBean entity = FastJSONHelper.getPerson(succeed, CollectionBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 商=添加购物车
     *
     * @param callBack
     */
    public static void addshopcar(String goodsid, String num, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("goodsid", goodsid);
        map.put("num", num);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.addshopcar(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        addshopcarBean entity = FastJSONHelper.getPerson(succeed, addshopcarBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 商=查看购物车
     *
     * @param callBack
     */
    public static void showshopcar(String page, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "10");
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.showshopcar(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        CartBean entity = FastJSONHelper.getPerson(succeed, CartBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 商=添加订单
     *
     * @param callBack
     */
    public static void addorders(String user_id,
                                 String addressid,
                                 String goodsid,
                                 String goodsnum,
                                 String shopcarids,
                                 String paymentmethod,
                                 String ordersmessage,
                                 String deductibletype,
                                 final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", user_id);
        map.put("addressid", addressid);
        map.put("goodsid", goodsid);
        map.put("goodsnum", goodsnum);
        map.put("shopcarids", shopcarids);
        map.put("paymentmethod", paymentmethod);
        map.put("ordersmessage", ordersmessage);
        map.put("deductibletype", deductibletype);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.addorders(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        ConfirmOrderBean entity = FastJSONHelper.getPerson(succeed, ConfirmOrderBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 商=查看用户订单
     *
     * @param callBack
     */
    public static void userorders(String user_id, String page, String type, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", user_id);
        map.put("page", page);
        map.put("number", "10");
        map.put("type", type);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.userorders(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        CollectionBean entity = FastJSONHelper.getPerson(succeed, CollectionBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

    /**
     * 商=用户商品搜索历史
     */
    public static void usergoodsselecthistory(String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", user_id);
        map.put("page", "1");
        map.put("number", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.usergoodsselecthistory(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        ShopSeacharBean entity = FastJSONHelper.getPerson(succeed, ShopSeacharBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }


    /**
     * 商=商品搜索历史
     *
     * @param callBack
     */
    public static void goodsselecthistory(String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", user_id);
        map.put("page", "1");
        map.put("number", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.goodsselecthistory(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        ShopSeacharBean entity = FastJSONHelper.getPerson(succeed, ShopSeacharBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }


    /**
     * 商=商品搜索历史
     *
     * @param callBack
     */
    public static void selectgoods(String page, String name, String cateid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", name);
        map.put("cateid", cateid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.selectgoods(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        ShopHomeBean entity = FastJSONHelper.getPerson(succeed, ShopHomeBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 视频=查看视频
     *
     * @param callBack
     */
    public static void videoshow(String videoid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoid", videoid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videoshow(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        ShopHomeBean entity = FastJSONHelper.getPerson(succeed, ShopHomeBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 视频=视频收藏
     *
     * @param callBack
     */
    public static void videocollection(String videoid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoid", videoid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videocollection(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        VideoPointBean entity = FastJSONHelper.getPerson(succeed, VideoPointBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 视频=视频取消收藏
     *
     * @param callBack
     */
    public static void videonotcollection(String videoid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoid", videoid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videonotcollection(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        VideoPointBean entity = FastJSONHelper.getPerson(succeed, VideoPointBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 视频=视频取消赞
     *
     * @param callBack
     */
    public static void videoisnotpoint(String videoid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoid", videoid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videoisnotpoint(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        VideoPointBean entity = FastJSONHelper.getPerson(succeed, VideoPointBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 视频=视频点赞
     *
     * @param callBack
     */
    public static void videoispoint(String videoid, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoid", videoid);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videoispoint(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        VideoPointBean entity = FastJSONHelper.getPerson(succeed, VideoPointBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 视频=视频评论
     *
     * @param callBack
     */
    public static void videomessage(String videoid, String user_id, String message, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoid", videoid);
        map.put("user_id", user_id);
        map.put("message", message);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videomessage(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        VideomessageBean entity = FastJSONHelper.getPerson(succeed, VideomessageBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 视频=获取所有视频评论
     *
     * @param callBack
     */
    public static void videomessageall(String page, String videoid, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("videoid", videoid);
        map.put("number", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videomessageall(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        VideoDetailBean entity = FastJSONHelper.getPerson(succeed, VideoDetailBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 视频=视频列表
     *
     * @param callBack
     */
    public static void videolist(String page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videolist(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        DetailCommetListBean entity = FastJSONHelper.getPerson(succeed, DetailCommetListBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 视频=视频打赏
     *
     * @param callBack
     */
    public static void videoreward(String videoid, String number, String user_id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoid", videoid);
        map.put("number", number);
        map.put("user_id", user_id);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.videoreward(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        DetailCommetListBean entity = FastJSONHelper.getPerson(succeed, DetailCommetListBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 视频=图文展示
     *
     * @param callBack
     */
    public static void imagetextfirstpage(String page, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("number", "12");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.imagetextfirstpage(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(String succeed) {
                        Logger.t("HttpHelper---").i(succeed);
                        CircleFragmentBean entity = FastJSONHelper.getPerson(succeed, CircleFragmentBean.class);
                        if (entity.getCode() == 0) {
                            if (entity.getError() == 0) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(String.valueOf(entity.getMsg()));
                            }
                        } else {
                            callBack.onFailure(String.valueOf(entity.getError()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t("HttpHelper").i(e.getMessage());
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

    public static MultipartBody.Part getPart(String path, String key) {
        if (TextUtils.isEmpty(path))
            return null;
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        //封装参数
        RequestBody rb = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part mp = MultipartBody.Part.createFormData(key, file.getName(), rb);
        return mp;
    }
}
