package com.hykj.liuzhi.androidcomponents.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.hykj.liuzhi.androidcomponents.MyApplication;
import com.hykj.liuzhi.androidcomponents.bean.LoginEntity;
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

    public static void saveUserdata(String user_data){
        Context context = MyApplication.getAppContext();
        if (context != null) {
            final SharedPreferences preferences = context.getSharedPreferences("Userdata", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("user_data", user_data);
            editor.apply();
        }
    }

    public static String getUserdata() {
        Context context = MyApplication.getAppContext();
        String str = "";
        if (context != null) {
            final SharedPreferences preferences = context.getSharedPreferences("Userdata", Context.MODE_PRIVATE);
            str =  preferences.getString("user_data", "");
        }
       return str;
    }

    public static int getUserId() {
        String userdata = LocalInfoUtils.getUserdata();
        int userid = 0;
        if (!TextUtils.isEmpty(userdata)){
            LoginEntity person = FastJSONHelper.getPerson(userdata, LoginEntity.class);
            if (person != null){
                userid = person.getUserdata().getUser_id();
            }
        }

        return userid;
    }

    public static void saveUserself(String user_data){
        Context context = MyApplication.getAppContext();
        if (context != null) {
            final SharedPreferences preferences = context.getSharedPreferences("Userself", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("user_data", user_data);
            editor.apply();
        }
    }

    public static String getUserself() {
        Context context = MyApplication.getAppContext();
        String str = "";
        if (context != null) {
            final SharedPreferences preferences = context.getSharedPreferences("Userself", Context.MODE_PRIVATE);
            str =  preferences.getString("user_data", "");
        }
        return str;
    }


}
