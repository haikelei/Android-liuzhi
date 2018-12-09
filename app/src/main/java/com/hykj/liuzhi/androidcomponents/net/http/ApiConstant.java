package com.hykj.liuzhi.androidcomponents.net.http;

public class ApiConstant {
    //正式
    public static final String ROOT_URL = "http://liuzhi.365hy.com";
    public static final String LOGIN = "/api/index/login";
    public static final String REGISTER = "/api/index/register";
    public static final String GETUSERSELF = "/api/index/getuserself";
    //用户关注的人
    public static final String GETUSERCOLLECTION = "/api/index/getusercollection";
    //用户的粉丝
    public static final String USER_FAN="/api/index/getuserfanse";
    //用户点击按钮 关注/已关注
    public static final String USER_CLICK_ATTENTION="/api/index/userfans";
    //用户收藏记录
    public static final String USER_COLLECTION_LIST = "/api/index/usercollection";
    //用户上传图文信息
    public static final String USER_ADD_IMAGTEXT = "/api/index/addimagetext";
}
