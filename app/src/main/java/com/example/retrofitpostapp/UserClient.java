package com.example.retrofitpostapp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserClient {

    @FormUrlEncoded
    @POST("interviewandroid.php")

    Call<CategoryPojo> sendEmail(
            //@Field-This is to be used along with a POST request. These define the parameters in POST request body
            @Field("email") String email
    );

}
