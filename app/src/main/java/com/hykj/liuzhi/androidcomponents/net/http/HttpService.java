package com.hykj.liuzhi.androidcomponents.net.http;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpService {
    @FormUrlEncoded
    @POST(ApiConstant.LOGIN)
    Observable<String> login(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(ApiConstant.REGISTER)
    Observable<String> register(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(ApiConstant.GETUSERCOLLECTION)
    Observable<String> getusercollection(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(ApiConstant.GETUSERSELF)
    Observable<String> getUserself(@FieldMap Map<String, String> map);

    /**
     * 获取用户粉丝
     */
    @FormUrlEncoded
    @POST(ApiConstant.USER_FAN)
    Observable<String> getUserFan(@FieldMap Map<String, String> map);

    /**
     * 用户点击按钮 关注/已关注
     */
    @FormUrlEncoded
    @POST(ApiConstant.USER_CLICK_ATTENTION)
    Observable<String> getUserClickAttention(@FieldMap Map<String, String> map);

    /**
     * 用户收藏记录
     */
    @FormUrlEncoded
    @POST(ApiConstant.USER_COLLECTION_LIST)
    Observable<String> getUserCollection(@FieldMap Map<String, String> map);

    /**
     * 用户上传图文信息
     */
    @FormUrlEncoded
    @POST(ApiConstant.USER_ADD_IMAGTEXT)
    Observable<String> getUseraddImagText(@FieldMap Map<String, String> map);

    /**
     * 首页=推荐
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_Firstpagedata)
    Observable<String> getFirstpagedata(@FieldMap Map<String, String> map);

    /**
     * 首页=纹理
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_Firstpagedatatexture)
    Observable<String> getFirstpagedatatexture(@FieldMap Map<String, String> map);

    /**
     * 首页=潮流
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_Firstpagedatatrend)
    Observable<String> getFirstpagedatatrend(@FieldMap Map<String, String> map);

    /**
     * 首页=搜索历史
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_Userselecthistory)
    Observable<String> getUserselecthistory(@FieldMap Map<String, String> map);

    /**
     * 首页=搜索
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_Userselect)
    Observable<String> getUserselect(@FieldMap Map<String, String> map);

    /**
     * 首页=签到
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_SignIn)
    Observable<String> getSignIn(@FieldMap Map<String, String> map);

    /**
     * 首页=签名
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_Changeautograph)
    Observable<String> getChangeautograph(@FieldMap Map<String, String> map);

    /**
     * 首页=昵称
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_Changenickname)
    Observable<String> getChangenickname(@FieldMap Map<String, String> map);
    /**
     * 首页=昵称
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_ChangEmail)
    Observable<String> getChangEmail(@FieldMap Map<String, String> map);
}
