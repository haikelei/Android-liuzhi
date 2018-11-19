package com.hykj.liuzhi.androidcomponents.net.http;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface HttpService {
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @FormUrlEncoded
    @POST(ApiConstant.LOGIN)
    Observable<String> login(@Field("phone") String phone, @Field("code") String code);

    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @FormUrlEncoded
    @POST(ApiConstant.REGISTER)
    Observable<String> register(@Field("phone") String phone, @Field("code") String code,@Field("password") String password);

    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @FormUrlEncoded
    @POST(ApiConstant.GETUSERSELF)
    Observable<String> getUserself();


}
