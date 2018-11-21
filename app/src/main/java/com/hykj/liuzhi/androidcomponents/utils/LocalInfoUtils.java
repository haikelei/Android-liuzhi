package com.hykj.liuzhi.androidcomponents.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.hykj.liuzhi.androidcomponents.MyApplication;
import com.hykj.liuzhi.androidcomponents.bean.User;
import com.hykj.liuzhi.androidcomponents.bean.UserInfo;

public class LocalInfoUtils {

    public static void saveUserInfo(String phone, String code,String password){
        Context context = MyApplication.getAppContext();
        if (context != null) {
            final SharedPreferences preferences = context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("phone", phone);
            editor.putString("code", code);
            editor.putString("password", password);
            editor.apply();
        }
    }


    public static UserInfo getUserInfo() {
        Context context = MyApplication.getAppContext();
        UserInfo userInfo = new UserInfo();
        if (context != null) {
            final SharedPreferences preferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
            userInfo.setPhone(preferences.getString("phone", ""));
            userInfo.setCode(preferences.getString("code", ""));
            userInfo.setPassword(preferences.getString("password", ""));
        }
        return userInfo;
    }
}
