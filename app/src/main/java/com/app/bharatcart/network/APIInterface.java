package com.app.bharatcart.network;


import com.app.bharatcart.pojo.Result;
import com.app.bharatcart.pojo.SignUp;
import com.app.bharatcart.pojo.UserExixts;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("/api/apps")
    Call<Result> getApps(@Query("country") String country,@Query("fullDetail") Boolean fullDetail,@Query("num") Integer num,@Query("q") String searchQuery);

    @POST("/api/user/checkUserExists")
    @FormUrlEncoded
    Call<UserExixts> checkUserExists(@Field("firebaseUID") String UID);

    @POST("/api/user/signup")
    @FormUrlEncoded
    Call<SignUp> signUp(@FieldMap Map<String,String> map);
}
