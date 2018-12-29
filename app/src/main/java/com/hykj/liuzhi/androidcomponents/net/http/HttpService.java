package com.hykj.liuzhi.androidcomponents.net.http;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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
     * 我的=邮箱
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_ChangEmail)
    Observable<String> getChangEmail(@FieldMap Map<String, String> map);

    /**
     * 我的=更换头像
     */
    @Multipart
    @POST(ApiConstant.Min_ChangeUserPic)
    Observable<String> getChangeUserPic(@Part MultipartBody.Part files);

    /**
     * 我的=收藏
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_UserCollection)
    Observable<String> getUserCollection(@FieldMap Map<String, String> map);

    /**
     * 我的=修改密码
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_ChangePassword)
    Observable<String> getChangePassword(@FieldMap Map<String, String> map);

    /**
     * 我的=登录记录
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_logonrecord)
    Observable<String> getlogonrecord(@FieldMap Map<String, String> map);

    /**
     * 我的=用户所有的收货地址
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_getUserAddress)
    Observable<String> getUserAddress(@FieldMap Map<String, String> map);

    /**
     * 我的=添加收货地址
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_addshopaddress)
    Observable<String> getAddshopaddress(@FieldMap Map<String, String> map);

    /**
     * 我的=省
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_getprovinces)
    Observable<String> getprovinces(@FieldMap Map<String, String> map);

    /**
     * 我的=市
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_getcitys)
    Observable<String> getcitys(@FieldMap Map<String, String> map);

    /**
     * 我的=区
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_getareas)
    Observable<String> getareas(@FieldMap Map<String, String> map);

    /**
     * 我的=获取所有标签
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_getlabels)
    Observable<String> getlabels(@FieldMap Map<String, String> map);

    /**
     * 我的=修改标签
     */
    @FormUrlEncoded
    @POST(ApiConstant.Min_changelabel)
    Observable<String> changelabel(@FieldMap Map<String, String> map);

    /**
     * 商品=获取轮播图片
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_Getsowing)
    Observable<String> Getsowing(@FieldMap Map<String, String> map);

    /**
     * 商品=商品展示
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_Goodsfirstpage)
    Observable<String> Goodsfirstpage(@FieldMap Map<String, String> map);

    /**
     * 商品=查看商品
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_showgoods)
    Observable<String> showgoods(@FieldMap Map<String, String> map);

    /**
     * 商品=商品收藏
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_goodscollection)
    Observable<String> goodscollection(@FieldMap Map<String, String> map);

    /**
     * 商品=商品取消收藏
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_goodsnotcollection)
    Observable<String> goodsnotcollection(@FieldMap Map<String, String> map);

    /**
     * 商品=添加购物车
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_addshopcar)
    Observable<String> addshopcar(@FieldMap Map<String, String> map);

    /**
     * 商品=查看购物车
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_showshopcar)
    Observable<String> showshopcar(@FieldMap Map<String, String> map);

    /**
     * 商品=添加订单
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_addorders)
    Observable<String> addorders(@FieldMap Map<String, String> map);

    /**
     * 商品=查看用户订单
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_userorders)
    Observable<String> userorders(@FieldMap Map<String, String> map);

    /**
     * 商品=用户商品搜索历史
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_usergoodsselecthistory)
    Observable<String> usergoodsselecthistory(@FieldMap Map<String, String> map);

    /**
     * 商品=商品搜索历史
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_goodsselecthistory)
    Observable<String> goodsselecthistory(@FieldMap Map<String, String> map);

    /**
     * 商品=商品查询
     */
    @FormUrlEncoded
    @POST(ApiConstant.Shop_selectgoods)
    Observable<String> selectgoods(@FieldMap Map<String, String> map);

    /**
     * 视频=查看视频
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videoshow)
    Observable<String> videoshow(@FieldMap Map<String, String> map);

    /**
     * 视频=视频收藏
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videocollection)
    Observable<String> videocollection(@FieldMap Map<String, String> map);

    /**
     * 视频=视频取消收藏
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videonotcollection)
    Observable<String> videonotcollection(@FieldMap Map<String, String> map);

    /**
     * 视频=视频取消赞
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videoisnotpoint)
    Observable<String> videoisnotpoint(@FieldMap Map<String, String> map);


    /**
     * 视频=视频点赞
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videoispoint)
    Observable<String> videoispoint(@FieldMap Map<String, String> map);

    /**
     * 视频=视频列表
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videolist)
    Observable<String> videolist(@FieldMap Map<String, String> map);
    /**
     * 视频=视频评论
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videomessage)
    Observable<String> videomessage(@FieldMap Map<String, String> map);
    /**
     * 视频=获取所有的视频评论
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videomessageall)
    Observable<String> videomessageall(@FieldMap Map<String, String> map);
    /**
     * 视频=视频打赏
     */
    @FormUrlEncoded
    @POST(ApiConstant.Home_videoreward)
    Observable<String> videoreward(@FieldMap Map<String, String> map);
    /**
     * 视频=图文展示
     */
    @FormUrlEncoded
    @POST(ApiConstant.Cirde_imagetextfirstpage)
    Observable<String> imagetextfirstpage(@FieldMap Map<String, String> map);
}